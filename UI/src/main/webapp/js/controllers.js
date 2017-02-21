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
    
    $scope.selectPatient = function(patient) {
    	$scope.selectedPatient = patient;
    }

    $scope.editPatient = function() {
        patientService.createPatient($scope.selectedPatient).then(function(response){
            //$scope.patients.push(response);
            $scope.selectedPatient = null;
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

app.controller("medicineController", function ($scope, $log, $q, $route, medicineService) {
    var medicines = {};

    (function start() {
        medicineService.allMedicines().then(
            function (medicines) {
                $scope.medicines = medicines;
                $log.debug(medicines);
            });
    })();
    $scope.$route = $route;

    $scope.selectMedicine = function(medicine) {
        $scope.selectedMedicine = medicine;
    }

    $scope.editMedicine = function() {
        medicineService.createMedicine($scope.selectedMedicine).then(function(response) {
            //$scope.patients.push(response);
            $scope.selectedMedicine = null;
        });
    };

    $scope.getMedicine = function () {
        var findId = $scope.findId;
        medicineService.getMedicineById(findId).then(function(response){
            $scope.result=response;
            $log.debug(response);
        });
    };
});

app.controller("clinicController", function ($scope, $log, $q, $route, clinicService) {
    var clinics = {};

    (function start() {
        clinicService.allClinics().then(
            function (clinics) {
                $scope.clinics = clinics;
                $log.debug(clinics);
            });
    })();
    $scope.$route = $route;

    $scope.editClinic = function() {
        var clinicObj = {
            clinicId: $scope.clinicId,
            clinicName: $scope.clinicName,
            clinicCity: $scope.clinicCity,
            clinicState: $scope.clinicState,
            clinicAddress: $scope.clinicAddress,
            clinicZip: $scope.clinicZip
        };
        clinicService.createClinic(clinicObj).then(function(response){
            $scope.clinics.push(response);
        });
    };

    $scope.getClinic = function () {
        var findId = $scope.findId;
        clinicService.getClinicById(findId).then(function(response){
            $scope.result=response;
            $log.debug(response);
        });
    };
});