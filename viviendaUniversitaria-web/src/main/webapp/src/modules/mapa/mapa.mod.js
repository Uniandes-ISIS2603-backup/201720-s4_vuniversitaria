(function (ng) {
        var mod = ng.module("mapaModule", ['ui.router', 'uiGmapgoogle-maps']);
        mod.constant("mapaContext", "api/mapa");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
     
            var basePath = 'src/modules/mapa/';
            $stateProvider.state('mapaTotal', {
                    url: '/mapa',
                    views: {
                         'mainView': {
                            templateUrl: basePath + 'mapa.html',
                            controller: 'mapaCtrl',
                            controllerAs: 'ctrl'
                          }
                    }
            });
        }]);
})(window.angular);
