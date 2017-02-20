app.factory("medicineService", function ($log, $http) {
    var medicines = {};

    medicines.allMedicines = function(){
        $log.debug( serverURL+"/medicineapi/medicine/all");
        return $http({
            url : serverURL+"/medicineapi/medicine/all",
            method : "GET"
        }).then(function(response) {
            $log.debug("Medicines successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    medicines.getMedicineById = function(id){
        return $http({
            url: serverURL+"/medicineapi/medicine/id/"+id,
            method:"GET"
        }).then(function(response){
            return response.data
        },function (response) {
            $log.response("There was an error: " + response.status);
        });
    };

    medicines.createMedicine = function(medicineObj){
        console.log(medicineObj);
        console.log("in Service");
        $log.debug(medicineObj);
        return $http({
            url: serverURL+"/medicineapi/medicine/save",
            method: "POST",
            data: medicineObj
        }).then(function (response) {
            $log.debug("Medicine created successfully")
            $log.debug(response);
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    medicines.editMedicine = function(medicineObj){
        $log.debug(medicineObj);
        return $http({
            url: serverURL+"/medicineapi/medicine/save",
            method: "POST",
            data: medicineObj
        }).then(function (response) {
            $log.debug("Medicine Edited successfully")
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    return medicines;
});