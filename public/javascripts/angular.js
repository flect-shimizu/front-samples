var app = angular.module('App', []);

app.controller("PhotoController", ["$scope", "$http",  function PhotoController($scope, $http) {
    $scope.photos = [];
    $scope.newTitle = '';

    $http.get("/photos")
        .success(function (data){
            $scope.photos = data;
    });
    $scope.addImage = function () {
        var postData = {title:$scope.newTitle}
        $http.post("/photo", postData)
            .success(function (data){
                $scope.photos.push(data);
                $scope.newTitle = '';
            });
    };

    $scope.removePhoto = function (photo, index) {
        $http.delete("/photo/" + photo.id)
            .success(function (data){
                $scope.photos.splice(index,1);
            });
    };
}]);
