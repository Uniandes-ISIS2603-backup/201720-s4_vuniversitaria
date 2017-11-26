(function (ng) {
    var mod = ng.module("origenModule", ['ui.router']);
    mod.constant("origenesContext", "api/origenes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/origenes/';
            $urlRouterProvider.otherwise("/origenesList");
            
            $stateProvider.state('origenes', {
                url: '/origenes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'origenes.html',
                        controller: 'origenCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('origenesList', {
                url: '/list',
                parent: 'origenes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'origenes.list.html'
                    }
                }
            }).state('origenDetail', {
                url: '/{origenesId:int}/detail',
                parent: 'origenes',
                param: {
                    origenesId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'origenes.detail.html',
                        controller: 'origenCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('agregarEstudiante',{
                url: '/{origenesId:int}/agregarEstudiante',
                parent:'origenes'
                ,param:{
                    origenesId:null
                }
                ,views:{
                   'listView':{
                        templateUrl:basePath + '/new/origenes.new.html'
                        ,controller:'origenNewCtrl'
                    }
                }
            }).state('origenUpdate',{
                url:'{origenId:int}/update'
                ,parent:'origenes'
                ,param:{
                    origenId:null
                }
                ,views:{
                    'detailView':{
                        templateUrl: basePath + '/update/origenes.update.html'
                        ,controller:'origenUpdateCtrl'
                    }
                }
            }).state('origenDelete',{
                url:'{origenId:int}/delete'
                ,parent:'origenes'
                ,param:{
                    origenId:null
                }
                ,views:{
                    'detailView':{
                        templateUrl: basePath + '/delete/origenes.delete.html'
                        ,controller:'origenDeleteCtrl'
                    }
                }
            }).state('origenCreate',{
                url:'/create'
                ,parent:'origenes'
                ,param:{
                    origenId:null
                }
                ,views:{
                    'detailView':{
                        templateUrl: basePath + '/create/origenes.create.html'
                        ,controller:'origenCreateCtrl'
                    }
                }
            });
        }]);
})(window.angular);
