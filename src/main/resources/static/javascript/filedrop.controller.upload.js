function UploadJsController($scope) {
    $scope.init = function() {
        $scope.files = [];
        $scope.uploadSize = 0;
    };

    $scope.submit = function() {
        if ($scope.files) {
            console.log($scope.files);
            console.log(($scope.uploadSize / 1024) / 1024, " MB");
        }
    };

    $scope.addFiles = function(files) {
        $scope.files = $scope.files.concat(files);
        angular.forEach(files, function(file) {
            $scope.uploadSize += file.size;
        });
    };

    $scope.removeFile = function (file) {
        var index = $scope.files.indexOf(file);
        if(index > -1) {
            $scope.files.splice(index, 1);
            $scope.uploadSize -= file.size;
        }
    };

    $scope.isUploadLarge = function() {
        return $scope.uploadSize > 100;
    }

    $scope.toMegaByte = function(bytes) {
        return (bytes / 1024) / 1024;
    }
}

filedropApp.controller("UploadJsController", UploadJsController);