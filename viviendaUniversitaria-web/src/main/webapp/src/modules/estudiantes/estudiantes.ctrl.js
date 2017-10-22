/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteCtrl', ['$scope', '$http', 'estudiantesContext',
        function ($scope, $http, estudiantesContext) {
            $http.get('data/estudiantes.json').then(function (response) {
                $scope.authorsRecords = response.data;
            });
        }
    ]);
}
)(angular);

