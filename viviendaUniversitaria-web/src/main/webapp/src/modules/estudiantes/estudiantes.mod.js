(function (ng) {
    var mod = ng.module("estudianteModule", ['ui.router']);
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/estudiantes/';
            $urlRouterProvider.otherwise("/estudiantesList");

            $stateProvider.state('estudiantes', {
                url: '/estudiantes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'estudiantes.html',
                        controller: 'estudianteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('estudiantesList', {
                url: '/list',
                parent: 'estudiantes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'estudiantes.list.html'
                    }
                }
            }).state('estudianteDetail', {
                url: '/{estudianteId:int}/detail',
                parent: 'estudiantes',
                views: {
                    'listView': {
                        templateUrl: basePath
                    },
                    'detailView': {
                        templateUrl: basePath + 'estudiantes.detail.html',
                        controller: 'estudianteCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            }).state('estudiantesCreate', {
                url: '/create',
                parent: 'estudiantes',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/estudiantes.new.html',
                        controller: 'estudianteNewCtrl'
                    }
                }
            }).state('estudianteDelete', {
                url: '/delete/{estudianteId:int}',
                parent: 'estudiantes',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/estudiantes.delete.html',
                        controller: 'estudianteDeleteCtrl'
                    }
                }
            }).state('estudianteUpdate', {
                url: '/update/{idEstudiante:int}',
                parent:'estudiantes',
                 param:{
                    idEstudiante: null
                },
                views:{
                    'detailView':{
                        templateUrl: basePath + '/update/estudiantes.update.html',
                        controller: 'estudianteUpdateCtrl'
                    }
                }
            });            
        }]);
})(window.angular);