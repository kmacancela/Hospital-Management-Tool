angular.module("app").config(
    function ($stateProvider, $locationProvider, $urlRouterProvider) {

        // go to home on startup
        $urlRouterProvider.otherwise('/home');

        // app states
        $stateProvider
            .state("home", {
                url: "/home",
                templateUrl: "app/partials/home.html",
            })

            .state("patient", {
                url: "/patients",
                templateUrl: "app/partials/patients.html",
                controller: "patientController",
                resolve: {
                    allPatients: function(delegate){
                        return delegate.patient.findAll();
                    }
                }
            })

            .state("medicine", {
                url: "/medicine",
                templateUrl: "app/partials/medicine.html",
                controller: "medicineController"
            })

            .state("clinic", {
                url: "/clinics",
                templateUrl: "app/partials/clinics.html",
                controller: "clinicController"
            })
    });