var serverURL = "http://localhost:8765";
var app = angular.module('app',['ngRoute']);
app.config(function ($locationProvider,$routeProvider, $logProvider) {
    $locationProvider.hashPrefix('');
    $logProvider.debugEnabled(true);
    $routeProvider
        .when('/',{
            templateUrl:'/pages/home.html'
        })
        .when('/patients',{
            templateUrl:'/pages/patients.html',
            controller: 'patientController'
        })
        .when('/medicine',{
            templateUrl:'/pages/medicine.html',
            controller: 'medicineController'
        })
        .when('/clinics',{
            templateUrl:'/pages/clinics.html',
            controller: 'clinicController'
        });
});