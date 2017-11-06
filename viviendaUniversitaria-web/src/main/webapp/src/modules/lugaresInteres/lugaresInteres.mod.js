(function (ng) {
    var mod = ng.module("lugaresInteresModule", ['ui.router']);
    mod.constant("lugaresInteresContext", "api/lugaresInteres");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/lugaresInteres/';
            $urlRouterProvider.otherwise("/lugaresInteres");
            $stateProvider.state('lugaresInteres', {
                url: '/lugaresInteres',
                views:{
                    'mainView':{
                        templateUrl: basePath+'lugaresInteres.html',
                        controller : 'lugaresInteresCtrl'
                    }
                }
            }).state('lugarInteresEspecifico',{
             url: '/lugaresInteres/{idLugarInteres:int}',
              param:{
                    idLugarInteres: 0
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'lugaresInteres.especifico.html',
                        controller : 'lugaresInteresCtrl'
                    }
                }
            }).state('lugarInteresEliminar',{
             url: '/lugaresInteres/{idLugarInteresDelete:int}',
              param:{
                    idLugarInteresDelete: 0
                },
                views:{
                    'mainView':{
                        templateUrl: basePath+'lugaresInteres.delete.html',
                        controller : 'lugaresInteresDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })        
        }
    ]);
})(window.angular);







