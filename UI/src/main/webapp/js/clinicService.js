app.factory("clinicService", function ($log, $http) {
    var clinics = {};

    clinics.allClinics = function(){
        $log.debug( serverURL+"/records/clinic/getAll");
        return $http({
            url : serverURL+"/records/clinic/getAll",
            method : "GET"
        }).then(function(response) {
            $log.debug("Clinics successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    clinics.getClinicById = function(id){
        return $http({
            url: serverURL+"/records/clinic/search/id/"+id,
            method:"GET"
        }).then(function(response){
            return response.data
        },function (response) {
            $log.response("There was an error: " + response.status);
        });
    };

    clinics.createClinic = function(clinicObj){
        console.log(clinicObj);
        console.log("in Service");
        $log.debug(clinicObj);
        return $http({
            url: serverURL+"/records/clinic/save",
            method: "POST",
            data: clinicObj
        }).then(function (response) {
            $log.debug("Clinic created successfully")
            $log.debug(response);
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    clinics.editMedicine = function(clinicObj){
        $log.debug(clinicObj);
        return $http({
            url: serverURL+"/records/clinic/save",
            method: "POST",
            data: clinicObj
        }).then(function (response) {
            $log.debug("Clinic Edited successfully")
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    return clinics;
});