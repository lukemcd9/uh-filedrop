function PrepareJsController($scope, dataProvider) {
    $scope.init = function (sender, helpdesk) {
        $scope.sender = sender;
        $scope.recipients = [];
        $scope.authentication = true;
        $scope.senderEmails = [];

        if (helpdesk) {
            $scope.recipient = "help@hawaii.edu";
            $scope.addRecipient();
        }

        dataProvider.loadData(function(response) {
           let data = response.data;
           $scope.senderEmails = data.mails;
        }, "/filedrop/api/ldap/" + sender);
    };

    $scope.addRecipient = function (recipient) {
        if (/^\s*$/.test(recipient) || recipient === undefined || $scope.hasRecipient(recipient)) {
            return;
        }

        dataProvider.loadData(function (response) {
            let data = response.data;
            if (data.cn) {
                $scope.recipients.push({ name: data.cn, uid: data.uid });
            } else if(recipient.indexOf("@") > -1) {
                $scope.authentication = false;
                $scope.recipients.push({ name: recipient });
            }
        }, "/filedrop/api/ldap/" + recipient);

        $scope.recipient = '';
    };

    $scope.removeRecipient = function (recipient) {
        let index = $scope.recipients.indexOf(recipient);

        if (index > -1) {
            $scope.recipients.splice(index, 1);
        }

        let auth = true;

        for(let r of $scope.recipients) {
            if(typeof r === "string" && r.indexOf("@") > -1) {
                auth = false;
            }
        }

        $scope.authentication = auth;
    };

    $scope.getRecipients = function () {
        let recipients = [];
        $scope.recipients.forEach(function (recipient) {
            recipients.push(recipient.uid ? recipient.uid : recipient.name);
        });
        return recipients.join(",");
    };

    $scope.hasRecipient = function (recipient) {
        return $scope.recipients.includes($scope.recipients.find(function (r) {
            return r.uid.toUpperCase() === recipient.toUpperCase() || r.name.toUpperCase() === recipient.toUpperCase();
        }));
    };

    $scope.userHasMultipleEmails = function() {
        return $scope.senderEmails.length >= 2;
    };
}

filedropApp.controller("PrepareJsController", PrepareJsController);