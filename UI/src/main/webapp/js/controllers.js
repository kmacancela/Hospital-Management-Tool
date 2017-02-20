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

    $scope.editMedicine = function() {
        var medicineObj = {
            medicineId: $scope.medicineId,
            name: $scope.name,
            type: $scope.type,
            price: $scope.price
        };
        medicineService.createMedicine(medicineObj).then(function(response){
            $scope.medicines.push(response);
        });
    };

    $scope.getMedicine = function () {
        var id = $scope.id;
        medicineService.getMedicineById(id).then(function(response){
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
        var id = $scope.id;
        clinicService.getClinicById(id).then(function(response){
            $scope.result=response;
            $log.debug(response);
        });
    };
});