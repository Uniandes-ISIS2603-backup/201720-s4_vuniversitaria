(function (ng) {
    var mod = ng.module("hospedajeModule", ['ui.router']);
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hospedaje/';
            $urlRouterProvider.otherwise("/hospedajes");
            $stateProvider.state('hospedaje', {
                url: '/hospedajes',
                
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedaje.html',
                        controller: 'hospedajeCtrl',
                        controllerAs: 'ctrl',
                    }
                }
            });
        }]);
})(window.angular);



