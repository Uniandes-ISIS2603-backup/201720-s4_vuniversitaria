(function (ng) {
    var mod = ng.module("loginModule", ['ui.router']);
    mod.constant("loginContext", "api/validar");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/login/';
            $stateProvider.state('login', {
                url: '/validar',
                views:{
                    'mainView':{
                        templateUrl: basePath+'login.html',
                        controller: 'loginControlador'
                    }
                }
            }).state('logout', {
                url: '/cerrar',
                views:{
                    'mainView':{
                        templateUrl: 'src/modules/home/home.html',
                        controller: 'logoutControlador'
                    }
                }
            }).state('sigin', {
                url: '/registrar',
                views:{
                    'mainView':{
                        templateUrl: 'src/modules/home/home.html',
                        controller: 'singinCtrl'
                    }
                }
            })
            ;
        }]);
})(window.angular);



