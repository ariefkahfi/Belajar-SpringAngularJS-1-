app.service('restService',function($http,$q,$resource){
    var rest = $resource('http://localhost:8989/arief/api/:to/:nim',{},{
       query : {
           method:"GET",
           params : {to :"mhs"},
           isArray : true
       },
       updateService : {
           method:"PUT",
           isArray: false,
           isObject : false
       }
    });


    this.updateData = function(modelNim ,    newModelNama,newModelGender){
        var defer = $q.defer();

        rest.updateService({to:"mhs",nim:modelNim},{nama:newModelNama,gender:newModelGender},function (success){
            defer.resolve(success);
        },function(error){
            defer.reject(error);
        });
        return defer.promise;
    };

    this.deleteData = function (modelNim){
        var defer = $q.defer();

        rest.delete({to:"mhs",nim:modelNim},function(success){
            defer.resolve(success);
        },function(error){
            defer.reject(error);
        });

        return defer.promise;
    }

    this.saveData = function (modelNim,modelNama,modelGender){
       rest.save({to:"mhs"},{nim:modelNim,nama:modelNama,gender:modelGender},function (success){
           console.log('insert data OK');
       },function (error){
           console.log(error);
       });
    };

    this.loadData = function(){
        var defer = $q.defer();
        rest.query(function (success){
            defer.resolve(success);
        },function(error){
            defer.reject(error);
        });
        return defer.promise;
    }
});