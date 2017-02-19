angular.module("app").controller("allGames",
    function ($http, $scope) {
        $http({
            url: "http://localhost:7001/games/game/all",
            method: "GET"
        }).then(function (response) {
            // server successfully sends data -- 200 code range
            // .data is response body
            $scope.games = response.data;
        }, function (response) {
            console.log("GET ALL: Failed to fetch games");
        });
    });

angular.module("app").controller("findGame",
    function ($http, $scope, $timeout) {
        $scope.fetch = function () {
            $http({
                url: "http://localhost:7001/games/game/" + $scope.query,
                method: "GET"
            }).then(function (response) {
                $scope.result = response.data;
                $scope.error = "";
            }, function (response) {
                $scope.result = "";
                $scope.error = response.statusText;
                $timeout(function () {
                    $scope.error = "";
                }, 2000);
            });
        }
    });

angular.module("app").controller("addGame",
    function ($http, $scope) {
        $scope.send = function () {
            var formData = {
                title: $scope.title,
                genre: $scope.genre
            };
            $http({
                url: "http://localhost:7001/games/game/",
                method: "POST",
                data: formData
            }).then(function (response) {
                // reset form
                $scope.title = "";
                $scope.genre = "";
            }, function (response) {
                console.log("Errors in data you're sending");
            });
        }
});