    (function (ng) {
    var mod = ng.module("reglaModule", ['ui.router']);
    mod.constant("reglaContext", "api/reglas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/regla/';
            $urlRouterProvider.otherwise("/regla");
            $stateProvider.state('reglaHospedaje', {
                url: '/{idHospedaje:int}/reglas',
                param: {
                    idHospedaje: null
                },
                views:{
                    'regas':{
                        templateUrl: basePath+'regla.html'
                    }
                }
            })
            ;
        }]);
})(window.angular);



