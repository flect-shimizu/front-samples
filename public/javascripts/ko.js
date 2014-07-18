function Photo(data) {
    this.id = ko.observable(data.id);
    this.title = ko.observable(data.title);
    this.url = ko.observable(data.url);
}

function PhotoListViewModel(photos) {
    // Data
    var self = this;
    self.photos = ko.observableArray(ko.utils.arrayMap(photos, function(data)  {
        return new Photo(data);
    }));
    self.newImageText = ko.observable();

    // Operations
    self.addImage = function () {
        var data = new Photo({ title: this.newImageText() });
        $.ajax({
            url: '/photo',
            data:ko.toJSON(data),
            contentType: 'application/json',
            type: 'POST',
            dataType: "json",
            success: function (json_data) {
                self.photos.push(new Photo(json_data));
                self.newImageText("");
            }
        })
    };
    self.removePhoto = function (photo) {
        $.ajax({
            url: '/photo/' + photo.id(),
            type: 'DELETE',
            success: function (result) {
                self.photos.remove(photo);
            }
        })
    }
}
$(function () {
    $.getJSON("/photos", function (data) {
        ko.applyBindings(new PhotoListViewModel(data));
    })
})

