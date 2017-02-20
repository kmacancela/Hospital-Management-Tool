app.factory("medicineService", function ($log, $http) {
    var medicine = {};

    medicine.allMedicine = function(){
        $log.debug( serverURL+"/medicine/medicine/all");
        return $http({
            url : serverURL+"/medicine/medicine/all",
            method : "GET"
        }).then(function(response) {
            $log.debug("Medicines successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    medicine.getMedicineById = function(id){
        return $http({
            url: serverURL+"/medicine/medicine/id/"+id,
            method:"GET"
        }).then(function(response){
            return response.data
        },function (response) {
            $log.response("There was an error: " + response.status);
        });
    };

    medicine.createMedicine = function(medicineObj){
        console.log(medicineObj);
        console.log("in Service");
        $log.debug(medicineObj);
        return $http({
            url: serverURL+"/medicine/medicine/save",
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

    medicine.editMedicine = function(medicineObj){
        $log.debug(medicineObj);
        return $http({
            url: serverURL+"/medicine/medicine/save",
            method: "POST",
            data: medicineObj
        }).then(function (response) {
            $log.debug("Medicine Edited successfully")
            return response.data;
        },function(response){
            $log.error("There was an error : " + response.status);
        });
    };

    return medicine;
});