(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies       
        'estudianteModule',
        'origenModule',
        'universidadModule',
        'ubicacionModule',
        'arrendadorModule',
        'lugaresInteresModule',
        'hospedajeModule'          
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);
