'use strict'
var shopService = angular.module('shopServices',['ngResource']);

shopService.factory('shopServices',function($resource){
    return $resource('/shop/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

shopService.service('totalCalService',function() {
    this.getTotalNetPrice = function (products) {
        var output = 0.0;

        for (var index = 0; index < products.length;index++) {
            var product = products[index];
            output += parseFloat(product.netPrice);
        }
        return output;
    }
})

shopService.factory('queryShopService',function($resource){
    return $resource('/getshop/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})