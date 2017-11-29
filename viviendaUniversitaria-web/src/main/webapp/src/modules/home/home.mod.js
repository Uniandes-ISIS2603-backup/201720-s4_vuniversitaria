(function (ng) {
    var mod = ng.module("homeModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/home/';
            $stateProvider.state('home', {
                url: '/home',
                views:{
                    'mainView':{
                        templateUrl: basePath+'home.html',
                        controller: 'homeCtrl'
                    }
                }
            })
            ;
        }]);
})(window.angular);



