//服务层
app.service('specificationService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../specification/findAll');		
	};
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../specification/findPage?page='+page+'&rows='+rows);
	};

	//模糊查找
	this.findPageByCondition = function (page,rows,entity) {
		return $http.post('../specification/findPageByEntity?page='+page+'&rows='+rows,entity);
	};
	//查询实体
	this.findOne=function(id){
		return $http.get('../specification/findOne?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('/specification/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../specification/update',entity );
	}
	this.deleteOne = function (id) {
		return $http.get('../specification/deleteOne?id='+id);
	};
	//删除
	this.deleteMany=function(ids){
		return $http.get('../specification/deleteMany?ids='+ids);
	}
	//搜索


});
