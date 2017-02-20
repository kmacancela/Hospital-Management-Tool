app.factory("clinicService", function ($log, $http) {
    var clinic = {};

    clinic.allClinic = function(){
        $log.debug( serverURL+"/clinic/clinic/all");
        return $http({
            url : serverURL+"/clinic/clinic/all",
            method : "GET"
        }).then(function(response) {
            $log.debug("Clinics successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    clinic.getClinicById = function(id){
        return $http({
            url: serverURL+"/clinic/clinic/id/"+id,
            method:"GET"
        }).then(function(response){
            return response.data
        },function (response) {
            $log.response("There was an error: " + response.status);
        });
    };

    clinic.createClinic = function(clinicObj){
        console.log(clinicObj);
        console.log("in Service");
        $log.debug(clinicObj);
        return $http({
            url: serverURL+"/clinic/clinic/save",
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

    clinic.editMedicine = function(clinicObj){
        $log.debug(clinicObj);
        return $http({
            url: serverURL+"/clinic/clinic/save",
            method: "POST",
            data: clinicObj
        }).then(function (response) {
            $log.debug("Clinic Edited successfully")
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    return clinic;
});