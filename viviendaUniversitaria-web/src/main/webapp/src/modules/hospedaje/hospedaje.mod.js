(function (ng) {
    var mod = ng.module("hospedajeModule", ['ui.router']);
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hospedaje/';
            var basePathRegla = 'src/modules/regla/';
            $urlRouterProvider.otherwise("/hospedajes");
            $stateProvider.state('hospedaje', {
                url: '/hospedajes',
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedaje.html',
                        controller: 'hospedajeCtrl',
                    }
                }
            }).state('hospedajeEspecifico', {
                url: '/hospedajes/{idHospedaje:int}',
                param:{
                    idHospedaje: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedajeEspecifico.html',
                        controller: 'hospedajeCtrl'
                    }
                }
            }).state('reglaHospedaje', {
                url: '/{idHospedaje:int}/reglas',
                param: {
                    idHospedaje: null
                },
                views:{
                    'mainView':{ //regaView
                        templateUrl: basePathRegla+'regla.html'
                    }
                }
            })
            .state('hospedajeEliminar', {
                url: '/hospedajes/{idHospedaje:int}',
                 param:{
                    idHospedaje: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedaje.delete.html',
                        controller: 'hospedajeDeleteCtrl',
                        controllerAs: 'c'
                    }
                }
            }).state('hospedajeCrear', {
                url: '/hospedajes',
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedaje.create.html',
                        controller: 'hospedajeCreateCtrl',
                        controllerAs: 'c'
                    }
                }
            }).state('hospedajeActualizar', {
                url: '/hospedajes/{idHospedaje:int}',
                 param:{
                    idHospedaje: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedaje.update.html',
                        controller: 'hospedajeUpdateCtrl',
                        controllerAs: 'c'
                    }
                }
            })
            ;
        }]);
})(window.angular);



