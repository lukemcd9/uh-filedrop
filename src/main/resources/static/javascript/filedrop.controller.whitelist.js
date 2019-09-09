function WhitelistJsController($scope, dataProvider) {
    var URL_LOAD = "/filedrop/api/admin/whitelist";

    $scope.init = function() {
        $scope.whitelist = [];
        $scope.loadData();
    };

    $scope.loadData = function() {
        dataProvider.loadData(function(data) {
            $scope.whitelist = data;
        }, URL_LOAD);
    };

    $scope.openModal = function() {
        $("#whitelistModal")
        .modal();
    };

    $scope.submit = function() {
        $("#whitelistModal")
        .modal("hide");
    };

    $scope.getEntryName = function(whitelist) {
        return whitelist.entryName ? whitelist.entryName : whitelist.entry;
    };

    $scope.getRegistrantName = function(whitelist) {
        return whitelist.registrantName ? whitelist.registrantName : whitelist.registrant;
    };
}

filedropApp.controller("WhitelistJsController", WhitelistJsController);