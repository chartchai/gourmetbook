'use strict';

var shopMainController = angular.module('shopMainController', ['shopServices']);

shopMainController.controller('addShopController', ['$scope', '$http', '$location', '$rootScope','shopServices',
    function ($scope, $http, $location, $rootScope,productService) {
        $scope.shop = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addProduct = function (flowFiles) {


            productService.save($scope.product,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var productid = data.id;
                // set location
                flowFiles.opts.target = '/productImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={productid:productid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("listProduct");
                $scope.$apply();
            });
        };


    }]);

shopMainController.controller('listshopController', ['$scope', '$http', '$rootScope','shopServices','$route','totalCalService','queryShopService',
    function ($scope, $http, $rootScope,shopServices,$route,totalCalService,queryProductService) {
        //$http.get("/product/").success(function (data) {
        var data = shopServices.query(function(){
           // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
            $scope.shops = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteProduct = function (id) {
            var answer = confirm("Do you want to delete the shop?");
            if (answer) {
                productService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }

        $scope.searchProduct = function(name){
           queryProductService.query({name:name},function(data) {
                $scope.products = data;
            });
        }

    }]);

shopMainController.controller('editShopController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','shopServices',
    function ($scope, $http, $routeParams, $location, $rootScope,productService) {
        $scope.addPerson = false;
        $scope.editPerson = true;
        var id = $routeParams.id;
        $http.get("/shop/" + id).success(function (data) {
            $scope.product = data;
        });

        $scope.editProduct = function () {
            //$http.put("/product", $scope.product).then(function () {
            productService.update({id:$scope.product.id},$scope.product,function(){
                $rootScope.editSuccess = true;
                $location.path("listProduct");
            });
        }
    }]);