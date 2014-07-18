$.getJSON("/photos").done(function(json){
    var app = new Vue({
        el: '#photoList',
        data: {
            photos: json,
            newTitle: ''
        },
        methods: {
            addImage: function (e) {
                var postData = JSON.stringify({title: app.newTitle});
                $.ajax({
                    url: '/photo',
                    data:postData,
                    contentType: 'application/json',
                    type: 'POST',
                    dataType: "json",
                    success: function (json_data) {
                        app.photos.push(json_data)
                        app.newTitle = ''
                    }
                })
            },
            removePhoto: function (id, index, ev) {
                $.ajax({
                    url: '/photo/' + id,
                    type: 'DELETE',
                    success:function (data){
                        app.photos.remove(index)
                    }
                })
            }
        }
    })
});

