app.controller('basecontroller',function ($scope) {

    $scope.reload = function () {
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
    $scope.idscheck=[];
    $scope.currentPage = 0;
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            if ($scope.currentPage!= $scope.paginationConf.currentPage) {
                $scope.reload();
                $scope.currentPage = $scope.paginationConf.currentPage;
            }
        }
    };

    $scope.ids=[];
    $scope.selectid=function ($event,id) {
        //怎么添加与删除
        if ($event.target.checked) {
            $scope.ids.push(id);
        } else{
            var index = $scope.ids.indexOf(id);
            $scope.ids.splice(index,1);
        }
    };

});