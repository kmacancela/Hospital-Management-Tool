var serverURL = "http://localhost:8765";
var app = angular.module('app',['ngRoute']);
app.config(function ($locationProvider,$routeProvider, $logProvider) {
    $locationProvider.hashPrefix('');
    $logProvider.debugEnabled(true);
    $routeProvider
        .when('/',{
            templateUrl:'/app/partials/home.html'
        })
        .when('/patients',{
            templateUrl:'/app/partials/patients.html',
            controller: 'patientController'
        })
        .when('/customers',{
            templateUrl:'/app/partials/medicine.html',
            controller: 'medicineController'
        })
        .when('/catalog',{
            templateUrl:'/app/partials/clinics.html',
            controller: 'clinicController'
        });
});