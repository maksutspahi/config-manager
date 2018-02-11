<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Configuration list</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2 class="hello-title">Configuration list</h2>
<script src="/js/jquery-3.3.1.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/actions.js"></script>

<button type="button" class="btn btn-info btn-lg create_btn">Create New</button>
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Type</th>
        <th>Value</th>
        <th>Application Name</th>
        <th>Is Active</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <#list configurations as config>
        <tr>
            <td>
                <a href="#" class="update_btn" data-id="${config.id}">${config.id}</a>
            </td>
            <td>${config.name}</td>
            <td>${config.type}</td>
            <td>${config.value}</td>
            <td>${config.applicationName}</td>
            <td>${config.active?string("yes","no")}</td>
            <td>
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                <a href="#" class="delete_btn" data-id="${config.id}">Delete</a>
            </td>
        </tr>
    </#list>

    </tbody>
</table>

<div id="saveModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <input type="hidden" name="configId" class="form-control" id="configId">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Configuration editor</h4>
            </div>
            <form id="create-form">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input name="name" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="exampleInputValue">Value</label>
                    <input name="value" class="form-control" id="value" placeholder="Enter value">
                </div>
                <div class="form-group">
                    <label for="sel1">Select type:</label>
                    <select id="type" class="form-control" id="sel1">
                        <option>STRING</option>
                        <option>INTEGER</option>
                        <option>DOUBLE</option>
                        <option>BOOLEAN</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="exampleInputValue">Application Name</label>
                    <input name="type" class="form-control" id="applicationName" placeholder="Enter Application Name" value="ty-client">
                </div>
                <div class="form-check">
                    <input type="checkbox" checked name="isActive" class="form-check-input" id="isActive">
                    <label class="form-check-label" for="exampleCheck1">Is Active</label>
                </div>
                <button type="button" class="btn btn-primary" onclick="saveConfig()">Save</button>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<script type="application/javascript">
    window.configs = ${configurationJson};
</script>

</body>
</html>