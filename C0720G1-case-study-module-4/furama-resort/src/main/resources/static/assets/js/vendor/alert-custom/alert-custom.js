$(document).ready(function () {
    $('.customer-type-1').css('color', '#1ec025');
    $('.customer-type-2').css('color', '#2c2459');
    $('.customer-type-3').css('color', '#ede012');
    $('.customer-type-4').css('color', '#ED109B');
    $('.customer-type-5').css('color', '#c00008');
});
$('#btn-create-form').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, save it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            swalWithBootstrapButtons.fire(
                'Success!',
                'Created New Customer.',
                'success'
            ).then(
                function () {
                    $('#form-create').submit();
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});


$('.deleteCustomer').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, Delete It!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    $.get(url);
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Deleted Customer.',
                        'success'
                    ).then(function () {
                        location.reload();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.editCustomer').click(function () {
    event.preventDefault();
    let id = $(this).attr('data');
    let url = $(this).attr('href');
    $.ajax({
        type: "GET", //GET, DELETE, PUT...
        url: "/api/customer-detail/" + id,
        dataType: "json",
        // dataType: "text",
        success: function (result) {
            $('#name').val(result.customerName);
            $('#birthday').val(result.customerBirthDay);
            switch (result.customerGender) {
                case 'Male':
                    $('#radio1').attr('checked', 'checked');
                    break;
                case 'Female':
                    $('#radio2').attr('checked', 'checked');
                    break;
            }
            $('#id').val(result.customerId);
            $('#select').val(result.customerType.customerTypeId);
            $('#id-card').val(result.customerIdCard);
            $('#phone').val(result.customerPhone);
            $('#email').val(result.customerEmail);
            $('#address').val(result.customerAddress);


        },
        error: function (result) {
            console.log('error;');
        }
    });
    $('#modalEdit').modal('show');
    $('#btn-edit-form').click(function () {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        });

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'question',
            showCancelButton: true,
            confirmButtonText: 'Yes, save it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                $(
                    function () {
                        $.get(url);
                        swalWithBootstrapButtons.fire(
                            'Success!',
                            'Customer was Updated.',
                            'success'
                        ).then(function () {
                            $('#form-edit').submit();
                        })
                    }
                )
            } else if (
                /* Read more about handling dismissals below */
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your action was not complete :)',
                    'error'
                )
            }
        })
    });
});
$('#selectServiceType').change(function () {
    let option = $(this).find(':selected').text();
    switch (option) {
        case 'villa':
            $("#standard").prop("disabled", false);
            $("#description").prop("disabled", false);
            $("#pool-area").prop("disabled", false);
            $("#floor").prop("disabled", false);
            break;
        case 'house':
            $("#standard").prop("disabled", false);
            $("#description").prop("disabled", false);
            $("#pool-area").prop("disabled", true);
            $("#floor").prop("disabled", false);
            break;
        case 'room':
            $("#standard").prop("disabled", true);
            $("#description").prop("disabled", true);
            $("#pool-area").prop("disabled", true);
            $("#floor").prop("disabled", true);

    }
});
$('#btn-create-form-complete').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, save it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Customer was Updated.',
                        'success'
                    ).then(function () {
                        $('#form').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.deleteService').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, Delete It!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    $.get(url);
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Deleted Customer.',
                        'success'
                    ).then(function () {
                        location.reload();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.editService').click(function () {
    event.preventDefault();
    let id = $(this).attr('data');
    let url = $(this).attr('href');
    $('#modalEditService').modal('show');
    $.ajax({
        type: "GET", //GET, DELETE, PUT...
        url: "/api/service-detail/" + id,
        dataType: "json",
        // dataType: "text",
        success: function (result) {
            $('#id-edit').val(result.serviceId);
            $('#name-edit').val(result.serviceName);
            $('#area-edit').val(result.serviceArea);
            $('#cost-edit').val(result.serviceCost);
            $('#max-people-edit').val(result.serviceMaxPeople);
            $('#selectServiceType-edit').val(result.serviceType.serviceTypeId);
            $('#selectRentType-edit').val(result.rentType.rentTypeId);
            $('#standard-edit').val(result.standardRoom);
            $('#description-edit').val(result.descriptionOtherConvenience);
            $('#pool-area-edit').val(result.poolArea);
            $('#floor-edit').val(result.numOfFloor);
        },
        error: function (result) {
            console.log('error;');
        }
    });
});
$('#btn-edit-service-complete').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, save it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Customer was Updated.',
                        'success'
                    ).then(function () {
                        $('#formEditService').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('#btn-crete-employee').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, create !',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Employee was Created.',
                        'success'
                    ).then(function () {
                        $('#form-create-employee').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.deleteEmployee').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    console.log(url);
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, Delete It!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    $.get(url);
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Deleted Employee.',
                        'success'
                    ).then(function () {
                        location.reload();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.editEmployee').click(function () {
    event.preventDefault();
    let id = $(this).attr('data');
    let url = $(this).attr('href');
    $('#modalEditEmployee').modal('show');
    $.ajax({
        type: "GET", //GET, DELETE, PUT...
        url: "/api/employee-detail/" + id,
        dataType: "json",
        // dataType: "text",
        success: function (result) {
            $('#idEdit').val(result.employeeId);
            $('#nameEdit').val(result.employeeName);
            $('#birthdayEdit').val(result.employeeBirthday);
            $('#id-cardEdit').val(result.employeeIdCard);
            $('#salaryEdit').val(result.employeeSalary);
            $('#phoneEdit').val(result.employeePhone);
            $('#emailEdit').val(result.employeeEmail);
            $('#addressEdit').val(result.employeeAddress);
            $('#selectPositionEdit').val(result.position.positionId);
            $('#selectEducationEdit').val(result.educationDegree.educationDegreeId);
            $('#selectDivisionEdit').val(result.division.divisionId);
            $('#usernameEdit').val(result.webUser.username);
        },
        error: function (result) {
            console.log('error;');
        }
    });
});
$('#btn-edit-employee-complete').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, save it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Employee was Updated.',
                        'success'
                    ).then(function () {
                        $('#form-edit-employee').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('#btn-crete-contract').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, create !',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Employee was Created.',
                        'success'
                    ).then(function () {
                        $('#form-create-contract').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.deleteContract').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    console.log(url);
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, Delete It!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    $.get(url);
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Deleted Contract.',
                        'success'
                    ).then(function () {
                        location.reload();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.contractDetail').click(function () {
    event.preventDefault();
    jQuery.noConflict();
    $('#modalContractDetail').modal('show');
    let id = $(this).attr('data');
    $('#contractId').val(id);
});
$('#btn-create-contract-detail').click(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, save it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Contract Detail Updated.',
                        'success'
                    ).then(function () {
                        $('#form-create-contract-detail').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('#btn-create-attach-service').click(function () {
    console.log('ok ?');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, create !',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Employee was Created.',
                        'success'
                    ).then(function () {
                        $('#form-create-attach').submit();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.deleteAttach').click(function () {
    event.preventDefault();
    let url = $(this).attr('href');
    console.log(url);
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes, Delete It!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $(
                function () {
                    $.post(url);
                    swalWithBootstrapButtons.fire(
                        'Success!',
                        'Deleted Contract.',
                        'success'
                    ).then(function () {
                        location.reload();
                    })
                }
            )
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your action was not complete :)',
                'error'
            )
        }
    })
});
$('.editAttach').click(function () {
    event.preventDefault();
    let id = $(this).attr('data');
    let url = $(this).attr('href');
    $('#modalAttachService').modal('show');
    $.ajax({
        type: "GET", //GET, DELETE, PUT...
        url: "/api/attach-detail/" + id,
        dataType: "json",
        // dataType: "text",
        success: function (result) {
            $('#idAttachEdit').val(result.attachServiceId);
            $('#nameAttEdit').val(result.attachServiceName);
            $('#costAttEdit').val(result.attachServiceCost);
            $('#unitAttEdit').val(result.attachServiceUnit);
            $('#statusAttEdit').val(result.attachServiceStatus);
        },
        error: function (result) {
            console.log('error;');
        }
    });
});
$('#total').click(function () {
    let option =parseInt($('#selectService option:selected').attr('data'));
    console.log(option);
    let start = new Date($('#start').val()),
        end = new Date($('#end').val()),
    diff = new Date(end - start),
        days = diff / 1000 / 60 / 60 / 24,
        total = days*40;
    if(isNaN(total)){
        total=option;
    }else{
     total+=option;
    }
    $('#total').val(total);
});
$(window).load(function () {
    if(!($('#title').text()==='')){
        console.log($('#title').text());
        let now = $.datepicker.formatDate('yy-mm-dd', new Date());
        $('#start').attr('min',now);
        if($('#start').val() === ''){
            $('#end').prop('disabled',true);
        }
        $('#start').change(function () {
            $('#end').prop('disabled',false);
            let start = $('#start').val();
            console.log(start);
            $('#end').attr('min',start);
        });
        let flag = $('#flag').attr('data');
        switch (flag) {
            case '1':
                jQuery.noConflict();
                $('#modal1').modal('show');
                break;
            case '2':
                break;
        }
    }else{
        let flag = $('#flag').attr('data');
        switch (flag) {
            case '1':
                $('#modal').modal('show');
                break;
            case '2':
                $('#modalEdit').modal('show');
                $('#modalEditService').modal('show');
                $('#modalEditEmployee').modal('show');
                break;
        }
    }
});

