function Complaint() {
    this.complaintId = 0;
    this.dateOfComplaintSubmission = '';
    this.comment = '';
    this.order = {
        orderId: 0,
        dateOfOrderSubmission: '',
        address: '',
        receiptDate: '',
        price: ''
    };
    this.orderPositions=
        [
        ];
    this.client = {
        clientId: 0,
        type: '',
        firstName: '',
        surname: '',
        eMail: ''
    }
}
Complaint.prototype.getComplaint = function () {
    return this;
};

function getExampleComplaint() {
    return getExampleComplaint(1);
}

function getExampleComplaint(index) {
    var complaint=new Complaint();

    complaint.complaintId = index;
    complaint.dateOfComplaintSubmission = new Date()+index;
    complaint.comment = 'niedobra pizza';
    complaint.order = {
        orderId: 1,
        dateOfOrderSubmission: new Date()+index,
        address: 'ul. Legnicka 33/33 Wroclaw',
        receiptDate: new Date()+index,
        price: 41+index*5
    };
    complaint.orderPositions=
        [
            {
                orderPositionId:1,
                count:2,
                price:22,
                rebate:'',
                product:getExamplePizza()
            },
            {
                orderPositionId:2,
                count:12,
                price:32,
                rebate:'',
                product:getExamplePizza()
            }
        ];
    complaint.client = {
        clientId: 0,
        type: 'staly',
        firstName: 'imie'+index,
        surname: 'nazwisko',
        eMail: 'nick'+index+'@wp.pl'
    };
    return complaint;
}

var getExampleComplaints = function (pageSize) {
    var arr=[];
    for(var i=1; i<pageSize+1;i++){
        arr.push(getExampleComplaint(i));
    }
    return arr;
};

// Product.prototype.initialize = function (obj) {
//     this.complaintId = 0;
//     this.dateOfComplaintSubmission = '';
//     this.comment = '';
//     this.order = {
//         orderId: 0,
//         dateOfOrderSubmission: '',
//         address: '',
//         receiptDate: '',
//         price: ''
//     };
//     this.client = {
//         clientId: 0,
//         type: '',
//         firstName: '',
//         surname: '',
//         eMail: ''
//     }
//
//     this.complaint = {
//         complaintId: obj.complaintId,
//         dateOfComplaintSubmission: obj.dateOfComplaintSubmission,
//         comment: obj.comment,
//         order: {
//             orderId: obj.order.orderId,
//             dateOfOrderSubmission: obj.order.dateOfOrderSubmission,
//             address: obj.order.address,
//             receiptDate: obj.order.receiptDate,
//             price: obj.order.price
//         },
//         client: {
//             clientId: obj.client.clientId,
//             type: obj.client.type,
//             firstName: obj.client.firstName,
//             surname: obj.client.surname,
//             eMail: obj.client.eMail
//         }
//     };
// }