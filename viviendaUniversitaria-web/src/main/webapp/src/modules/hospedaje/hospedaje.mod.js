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
            }).state('elimiarRegla', {
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
            }).state('hospedajeEliminar', {
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
            }).state('crearRegla', {
                url: '/hospedajes/{idHospedaje:int}/reglas',
                 param:{
                    idHospedaje: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'regla/regla.create.html',
                        controller: 'hospedajeCtrl',
                        controllerAs: 'c'
                    }
                }
            })
            ;
        }]);
})(window.angular);



