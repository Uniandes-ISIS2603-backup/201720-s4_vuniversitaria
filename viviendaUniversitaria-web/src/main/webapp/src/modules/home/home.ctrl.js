(function (ng) {
    var mod = ng.module("homeModule");
    mod.controller('homeCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {

            $scope.myInterval = 3000;
            $scope.slides = [
                {
                    image: 'resources/images/new.jpg',
                    text: "ÚNETE A NUESTRA COMUNIDAD DE ESTUDIANTES Y EMPRENDEDORES"
                },
                {
                    image: 'resources/images/man.jpg',
                    text: "ENCUENTRA EL LUGAR IDEAL PARA TU ESTADÍA"
                },
                {
                    image: 'resources/images/a.jpg',
                    text: "CONVIERTETE EN PARTE DE NUESTRA GRAN FAMILIA"
                }
            ];

        }
    ]);
}
)(angular);

