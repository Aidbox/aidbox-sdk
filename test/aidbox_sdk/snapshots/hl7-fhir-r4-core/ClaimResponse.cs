using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ClaimResponse : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public Base.ResourceReference? Requestor { get; set; }
    public Base.CodeableConcept? PayeeType { get; set; }
    public ClaimResponse_Insurance[]? Insurance { get; set; }
    public Base.ResourceReference? Request { get; set; }
    public ClaimResponse_ProcessNote[]? ProcessNote { get; set; }
    public string? PreAuthRef { get; set; }
    public ClaimResponse_Adjudication[]? Adjudication { get; set; }
    public required string Use { get; set; }
    public ClaimResponse_Payment? Payment { get; set; }
    public ClaimResponse_Item[]? Item { get; set; }
    public required Base.CodeableConcept Type { get; set; }
    public required string Created { get; set; }
    public Base.Period? PreAuthPeriod { get; set; }
    public required string Outcome { get; set; }
    public string? Disposition { get; set; }
    public Base.ResourceReference[]? CommunicationRequest { get; set; }
    public ClaimResponse_Total[]? Total { get; set; }
    public required Base.ResourceReference Insurer { get; set; }
    public Base.CodeableConcept? FundsReserve { get; set; }
    public required string Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public ClaimResponse_Error[]? Error { get; set; }
    public Base.Attachment? Form { get; set; }
    public Base.CodeableConcept? SubType { get; set; }
    public Base.CodeableConcept? FormCode { get; set; }
    public ClaimResponse_AddItem[]? AddItem { get; set; }

    public class ClaimResponse_Insurance : BackboneElement
    {
        public required bool Focal { get; set; }
        public required Base.ResourceReference Coverage { get; set; }
        public required string Sequence { get; set; }
        public Base.ResourceReference? ClaimResponse { get; set; }
        public string? BusinessArrangement { get; set; }
    }

    public class ClaimResponse_ProcessNote : BackboneElement
    {
        public required string Text { get; set; }
        public string? Type { get; set; }
        public string? Number { get; set; }
        public Base.CodeableConcept? Language { get; set; }
    }

    public class ClaimResponse_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_Payment : BackboneElement
    {
        public string? Date { get; set; }
        public required Base.CodeableConcept Type { get; set; }
        public required Base.Money Amount { get; set; }
        public Base.Money? Adjustment { get; set; }
        public Base.Identifier? Identifier { get; set; }
        public Base.CodeableConcept? AdjustmentReason { get; set; }
    }

    public class ClaimResponse_Item_Detail_SubDetail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_Item_Detail_SubDetail : BackboneElement
    {
        public string[]? NoteNumber { get; set; }
        public ClaimResponse_Item_Detail_SubDetail_Adjudication[]? Adjudication { get; set; }
        public required string SubDetailSequence { get; set; }
    }

    public class ClaimResponse_Item_Detail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_Item_Detail : BackboneElement
    {
        public ClaimResponse_Item_Detail_SubDetail[]? SubDetail { get; set; }
        public string[]? NoteNumber { get; set; }
        public required ClaimResponse_Item_Detail_Adjudication[] Adjudication { get; set; }
        public required string DetailSequence { get; set; }
    }

    public class ClaimResponse_Item_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_Item : BackboneElement
    {
        public ClaimResponse_Item_Detail[]? Detail { get; set; }
        public string[]? NoteNumber { get; set; }
        public required ClaimResponse_Item_Adjudication[] Adjudication { get; set; }
        public required string ItemSequence { get; set; }
    }

    public class ClaimResponse_Total : BackboneElement
    {
        public required Base.Money Amount { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_Error : BackboneElement
    {
        public required Base.CodeableConcept Code { get; set; }
        public string? ItemSequence { get; set; }
        public string? DetailSequence { get; set; }
        public string? SubDetailSequence { get; set; }
    }

    public class ClaimResponse_AddItem_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_AddItem_Detail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_AddItem_Detail_SubDetail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ClaimResponse_AddItem_Detail_SubDetail : BackboneElement
    {
        public Base.Money? Net { get; set; }
        public string? Factor { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.Money? UnitPrice { get; set; }
        public string[]? NoteNumber { get; set; }
        public required ClaimResponse_AddItem_Detail_SubDetail_Adjudication[] Adjudication { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
    }

    public class ClaimResponse_AddItem_Detail : BackboneElement
    {
        public Base.CodeableConcept[]? Modifier { get; set; }
        public required ClaimResponse_AddItem_Detail_Adjudication[] Adjudication { get; set; }
        public Base.Money? Net { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public string? Factor { get; set; }
        public ClaimResponse_AddItem_Detail_SubDetail[]? SubDetail { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public string[]? NoteNumber { get; set; }
        public Base.Money? UnitPrice { get; set; }
    }

    public class ClaimResponse_AddItem : BackboneElement
    {
        public Base.Address? LocationAddress { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public required ClaimResponse_AddItem_Adjudication[] Adjudication { get; set; }
        public string[]? SubdetailSequence { get; set; }
        public Base.CodeableConcept? LocationCodeableConcept { get; set; }
        public string[]? ItemSequence { get; set; }
        public Base.Money? Net { get; set; }
        public object? Serviced    
        {
            get
            {
                if (ServicedDate is not null)
                {
                    return ServicedDate;
                }
        
                if (ServicedPeriod is not null)
                {
                    return ServicedPeriod;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ServicedDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    ServicedPeriod = (Base.Period)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string[]? DetailSequence { get; set; }
        public Base.CodeableConcept[]? SubSite { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public Base.ResourceReference? LocationReference { get; set; }
        public Base.CodeableConcept[]? ProgramCode { get; set; }
        public string? Factor { get; set; }
        public string? ServicedDate { get; set; }
        public Base.CodeableConcept? BodySite { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public object? Location    
        {
            get
            {
                if (LocationAddress is not null)
                {
                    return LocationAddress;
                }
        
                if (LocationCodeableConcept is not null)
                {
                    return LocationCodeableConcept;
                }
        
                if (LocationReference is not null)
                {
                    return LocationReference;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Address))
                {
                    LocationAddress = (Base.Address)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    LocationCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    LocationReference = (Base.ResourceReference)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference[]? Provider { get; set; }
        public string[]? NoteNumber { get; set; }
        public Base.Money? UnitPrice { get; set; }
        public Base.Period? ServicedPeriod { get; set; }
        public ClaimResponse_AddItem_Detail[]? Detail { get; set; }
    }
}