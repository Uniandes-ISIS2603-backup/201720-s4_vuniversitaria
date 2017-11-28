(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
         'uiGmapgoogle-maps',
        // Internal modules dependencies  
        'reservaModule',
        'facturaModule',
        'estudianteModule',
        'origenModule',
        'universidadModule',
        'ubicacionModule',
        'arrendadorModule',
        'lugaresInteresModule',
        'hospedajeModule',
        'mapaModule',
        'loginModule'
    ]);
    //Resuelve problemas
    app.config(['$qProvider','uiGmapGoogleMapApiProvider', function ($qProvider,uiGmapGoogleMapApiProvider) {
               uiGmapGoogleMapApiProvider.configure({
                 key: 'AIzaSyAGX2fd-BcdoHwrTtZbtrcxNM9j7WUrxSY',
                 v: '3.20', //defaults to latest 3.X anyhow
                 libraries: 'weather,geometry,visualization'
        });
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);
