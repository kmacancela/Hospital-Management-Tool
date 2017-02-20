app.controller("patientController", function ($scope, $log, $q, $route, patientService) {
    var patients = {};

    (function start() {
        patientService.allPatients().then(
            function (patients) {
                $scope.patients = patients;
                $log.debug(patients);
            });
    })();
    $scope.$route = $route;

    $scope.editPatient = function() {
        var patientObj = {
        	patientId: $scope.patientId,
            patientFirstName: $scope.patientFirstName,
            patientLastName: $scope.patientLastName,
            phoneNumber: $scope.phoneNumber
        };
        patientService.createPatient(patientObj).then(function(response){
            $scope.patients.push(response);
        });
    };

    $scope.getPatient = function () {
        var id = $scope.id;
        patientService.getPatientById(id).then(function(response){
        	$scope.result=response;
            $log.debug(response);
        });
    };
});