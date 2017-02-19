angular.module("app").controller("allPatients",
    function ($http, $scope) {
        $http({
            url: "http://localhost:12349/patient/all",
            method: "GET"
        }).then(function (response) {
            $scope.patient = response.data;
        }, function (response) {
            console.log("GET ALL: Failed to fetch patients");
        });
    });

angular.module("app").controller("findPatient",
    function ($http, $scope, $timeout) {
        $scope.fetch = function () {
            $http({
                url: "http://localhost:12349/patient/id/" + $scope.query,
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

angular.module("app").controller("addPatient",
    function ($http, $scope) {
        $scope.send = function () {
            var formData = {
                patientFirstName: $scope.patientFirstName,
                patientLastName: $scope.patientLastName,
                phoneNumber: $scope.phoneNumber
            };
            $http({
                url: "http://localhost:12349/patient/save",
                method: "POST",
                data: formData
            }).then(function (response) {
                // reset form
                $scope.patientFirstName = "";
                $scope.patientLastName = "";
                $scope.phoneNumber = "";
            }, function (response) {
                console.log("Errors in data you're sending");
            });
        }
    });