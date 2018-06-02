function showAdd() {
    document.querySelector(".dialog").style.display = "block";
    document.querySelector(".cus-add").style.display = "block";
}
function closeAdd() {
    document.querySelector(".dialog").style.display = "none";
    document.querySelector(".cus-add").style.display = "none";
}

function showEdit() {
    var checkboxes = document.getElementsByName("item");
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            var id = checkboxes[i];
            break;
        }
    }
    document.getElementById("edit-id").value = id.value;
    var name = id.parentNode.nextSibling.nextSibling;
    document.getElementById("edit-name").value = name.innerHTML;
    var next = name.nextSibling.nextSibling;
    if (next.innerHTML == "男") {
        document.getElementById("edit-gender-male").checked = "checked";
    } else {
        document.getElementById("edit-gender-female").checked = "checked";
    }
    next = next.nextSibling.nextSibling;
    document.getElementById("edit-phone").value = next.innerHTML;
    next = next.nextSibling.nextSibling;
    document.getElementById("edit-email").value = next.innerHTML;
    document.querySelector(".dialog").style.display = "block";
    document.querySelector(".cus-edit").style.display = "block";
}
function closeEdit() {
    var checkboxes = document.getElementsByName("item");
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            checkboxes[i].checked = false;
        }
    }
    document.querySelector(".dialog").style.display = "none";
    document.querySelector(".cus-edit").style.display = "none";
}

function delCus() {
    if (window.confirm("是否继续删除？")) {
        return true;
    }
    return false;
}