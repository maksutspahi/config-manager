$(document).ready(function () {

    $('.create_btn').on('click', function (e) {
        e.preventDefault();
        $('#configId').val('');
        $('#saveModal').modal('show');
    });

    $('.delete_btn').on('click', function (e) {
        e.preventDefault();
        deleteConfig(this);
    });

    $('.update_btn').on('click', function (e) {
        e.preventDefault();
        updateConfig(this);
        $('#saveModal').modal('show');
    });
});

function getData() {
    return {
        'name': $('#name').val(),
        'value': $('#value').val(),
        'active': $('#isActive').is(':checked'),
        'type': $('#type').val(),
        'applicationName': $('#applicationName').val()
    };
}

function saveConfig() {

    var id = $('#configId').val();
    if (id && id != '') {
        var $url = '/api/update/' + id;
    } else {
        var $url = '/api/create';
    }

    $.ajax({
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        url: $url,
        data: JSON.stringify(getData()),
        complete: function () {
            location.reload();
        }
    })
};

function deleteConfig(link) {
    var id = $(link).data('id');
    var $url = '/api/delete/' + id;

    $.ajax({
        type: 'POST',
        url: $url,
        complete: function () {
            location.reload();
        }
    })
}

function updateConfig(link) {
    var id = $(link).data('id');
    var selected = window.configs[id];
    $('#configId').val(id),
        $('#name').val(selected.name),
        $('#value').val(selected.value),
        $('#isActive').prop('checked', selected.active),
        $('#type').val(selected.type),
        $('#applicationName').val(selected.applicationName)
}