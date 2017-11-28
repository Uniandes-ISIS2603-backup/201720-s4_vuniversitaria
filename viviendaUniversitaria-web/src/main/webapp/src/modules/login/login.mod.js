(function (ng) {
    var mod = ng.module("loginModule", ['ui.router']);
    mod.constant("loginContext", "api/validar");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/login/';
            $urlRouterProvider.otherwise("/login");
            $stateProvider.state('login', {
                url: '/validar',
                views:{
                    'mainView':{
                        templateUrl: basePath+'login.html',
                        controller: 'loginControlador'
                    }
                }
            })
            ;
        }]);
})(window.angular);



