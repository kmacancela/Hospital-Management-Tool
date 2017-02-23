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
    
    $scope.getVisitsOfPatient = function(){
    	var id = $scope.id;
    	patientService.getVisitsByPatientId(id).then(function(response){
    		$scope.visits=response;
    	})
    }
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
    
    $scope.selectClinic = function(clinic) {
    	$scope.selectedClinic = clinic;
    }

    $scope.editClinic = function() {
        clinicService.createClinic($scope.selectedClinic).then(function(response){
            $scope.selectedClinic = null;
            //$scope.clinics.push(response);
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