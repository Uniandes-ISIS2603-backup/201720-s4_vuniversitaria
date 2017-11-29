(function (ng) {
    var mod = ng.module("hospedajeModule", ['ui.router']);
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hospedaje/';
            $stateProvider.state('hospedaje', {
                url: '/hospedajes',
                views:{
                    'mainView':{
                        templateUrl: basePath+'hospedaje.html',
                        controller: 'hospedajeCtrl'
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
            }).state('calificacionesDelete', {
                url: '/hospedajes/{idHospedaje:int}/calificaciones/delete/{idCalificacion:int}',
                 param:{
                    idHospedaje: null,
                    idCalificacion: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'calificaciones/calificaciones.delete.html',
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
            }).state('modificarRegla', {
                url: '/hospedajes/{idHospedaje:int}/reglas/{idRegla:int}',
                 param:{
                    idHospedaje: null,
                    idRegla: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'regla/regla.modificar.html',
                        controller: 'reglaUpdate',
                        controllerAs: 'c'
                    }
                }
            }).state('calificacionesCreate', {
                url: '/hospedajes/{idHospedaje:int}/calificaciones',
                 param:{
                    idHospedaje: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'calificaciones/calificaciones.create.html',
                        controller: 'hospedajeCtrl'
                    }
                }
            }).state('serviciosUpdate', {
                url: '/hospedajes/{idHospedaje:int}/servicios/{idServicio:int}',
                 param:{
                    idHospedaje: null,
                    idServicio: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'servicios/servicios.update.html',
                        controller: 'hospedajeCtrl'
                    }
                }
            }).state('serviciosDelete', {
                url: '/hospedajes/{idHospedaje:int}/servicios/delete/{idServicio:int}',
                 param:{
                    idHospedaje: null,
                    idServicio: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'servicios/servicios.delete.html',
                        controller: 'hospedajeCtrl'
                    }
                }
            }).state('serviciosCreate', {
                url: '/hospedajes/{idHospedaje:int}/servicios/create',
                 param:{
                    idHospedaje: null
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'servicios/servicios.create.html',
                        controller: 'hospedajeCtrl'
                    }
                }
            })
            ;
        }]);
})(window.angular);



