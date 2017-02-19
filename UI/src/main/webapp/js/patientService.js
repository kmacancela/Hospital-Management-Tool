app.factory("patientService", function ($log, $http) {
    var patients = {};

    patients.allPatients = function(){
        return $http({
            url : serverURL+"/patient/all",
            method : "GET"
        }).then(function(response) {
            $log.debug("Patients successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    patients.getPatientById = function(id){
        return $http({
            url: serverURL+"/patient/id/"+id,
            method:"GET"
        }).then(function(response){
            return response.data
        },function (response) {
            $log.response("There was an error: " + response.status);
        });
    };

    patients.createPatient = function(patientObj){
        console.log(patientObj);
        console.log("in Service");
        $log.debug(patientObj);
        return $http({
            url: serverURL+"/patient/save",
            method: "POST",
            data: patientObj
        }).then(function (response) {
            $log.debug("Patient created successfully")
            $log.debug(response);
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    patients.editCustomer = function(patientObj){
        $log.debug(patientObj);
        return $http({
            url: serverURL+"/patient/save",
            method: "POST",
            data: patientObj
        }).then(function (response) {
            $log.debug("Patient Edited successfully")
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };




    return patients;
});