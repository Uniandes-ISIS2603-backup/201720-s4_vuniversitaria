/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    // Definición del módulo
    var mod = ng.module("estudianteModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/estudiantes/';
            $urlRouterProvider.otherwise("/estudiantesList");
            $stateProvider.state('estudiantesList', {
                // Url que aparecerá en el browser
                url: '/estudiantes/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'estudiantes.list.html',
                        controller: 'estudianteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);



