angular.module("delegate").factory("delegate",
    function (patientFactory, medicineFactory, clinicFactory) {

        var delegate = {};

        delegate.patient = {};
        delegate.medicine = {};
        delegate.clinic = {};

        /**************************** Patients *****************************/
        delegate.patient.savePatient = function(patientObj){
            return patientFactory.savePatient(patientObj);
        };

        delegate.patient.findOne = function(patientObj){
            return patientFactory.findOne(patientObj);
        };

        delegate.patient.findAll = function(){
            return patientFactory.findAll();
        };

        /**************************** Medicine *****************************/
        delegate.medicine.saveMedicine = function(medicineObj){
            return medicineFactory.saveMedicine(medicineObj);
        };

        delegate.medicine.findOne = function(medicineObj){
            return medicineFactory.findOne(medicineObj);
        };

        delegate.medicine.findAll = function(){
            return medicineFactory.findAll();
        };

        /**************************** Clinics *****************************/
        delegate.clinic.savePatient = function(clinicObj){
            return clinicFactory.saveClinic(clinicObj);
        };

        delegate.clinic.findOne = function(clinicObj){
            return clinicFactory.findOne(clinicObj);
        };

        delegate.clinic.findAll = function(){
            return clinicFactory.findAll();
        };

        return delegate;
    });