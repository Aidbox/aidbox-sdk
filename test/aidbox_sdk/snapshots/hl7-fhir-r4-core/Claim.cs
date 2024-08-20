using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class Claim : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public required Claim_Insurance[] Insurance { get; set; }
    public Base.ResourceReference? Facility { get; set; }
    public Claim_Diagnosis[]? Diagnosis { get; set; }
    public Base.ResourceReference? Enterer { get; set; }
    public Claim_SupportingInfo[]? SupportingInfo { get; set; }
    public required string Use { get; set; }
    public Claim_Item[]? Item { get; set; }
    public required Base.CodeableConcept Type { get; set; }
    public required string Created { get; set; }
    public Claim_Procedure[]? Procedure { get; set; }
    public Claim_Related[]? Related { get; set; }
    public Base.ResourceReference? Referral { get; set; }
    public Base.Money? Total { get; set; }
    public Base.ResourceReference? Insurer { get; set; }
    public Base.CodeableConcept? FundsReserve { get; set; }
    public required Base.CodeableConcept Priority { get; set; }
    public Claim_Accident? Accident { get; set; }
    public required string Status { get; set; }
    public Claim_Payee? Payee { get; set; }
    public Base.ResourceReference? Prescription { get; set; }
    public Base.Period? BillablePeriod { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.CodeableConcept? SubType { get; set; }
    public required Base.ResourceReference Provider { get; set; }
    public Base.ResourceReference? OriginalPrescription { get; set; }
    public Claim_CareTeam[]? CareTeam { get; set; }

    public class Claim_Insurance : BackboneElement
    {
        public required bool Focal { get; set; }
        public required Base.ResourceReference Coverage { get; set; }
        public required string Sequence { get; set; }
        public Base.Identifier? Identifier { get; set; }
        public string[]? PreAuthRef { get; set; }
        public Base.ResourceReference? ClaimResponse { get; set; }
        public string? BusinessArrangement { get; set; }
    }

    public class Claim_Diagnosis : BackboneElement
    {
        public Base.CodeableConcept[]? Type { get; set; }
        public required string Sequence { get; set; }
        public object? Diagnosis    
        {
            get
            {
                if (DiagnosisReference is not null)
                {
                    return DiagnosisReference;
                }
        
                if (DiagnosisCodeableConcept is not null)
                {
                    return DiagnosisCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    DiagnosisReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DiagnosisCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? OnAdmission { get; set; }
        public Base.CodeableConcept? PackageCode { get; set; }
        public Base.ResourceReference? DiagnosisReference { get; set; }
        public Base.CodeableConcept? DiagnosisCodeableConcept { get; set; }
    }

    public class Claim_SupportingInfo : BackboneElement
    {
        public required Base.CodeableConcept Category { get; set; }
        public Base.ResourceReference? ValueReference { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public Base.Period? TimingPeriod { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueAttachment is not null)
                {
                    return ValueAttachment;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ValueReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    ValueAttachment = (Base.Attachment)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueString { get; set; }
        public bool? ValueBoolean { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public object? Timing    
        {
            get
            {
                if (TimingPeriod is not null)
                {
                    return TimingPeriod;
                }
        
                if (TimingDate is not null)
                {
                    return TimingDate;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Period))
                {
                    TimingPeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimingDate = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public required string Sequence { get; set; }
        public Base.CodeableConcept? Code { get; set; }
        public string? TimingDate { get; set; }
        public Base.Attachment? ValueAttachment { get; set; }
    }

    public class Claim_Item_Detail_SubDetail : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? Revenue { get; set; }
        public Base.Money? Net { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public Base.ResourceReference[]? Udi { get; set; }
        public Base.CodeableConcept[]? ProgramCode { get; set; }
        public string? Factor { get; set; }
        public required string Sequence { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.Money? UnitPrice { get; set; }
    }

    public class Claim_Item_Detail : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? Revenue { get; set; }
        public Base.Money? Net { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public Base.ResourceReference[]? Udi { get; set; }
        public Base.CodeableConcept[]? ProgramCode { get; set; }
        public string? Factor { get; set; }
        public required string Sequence { get; set; }
        public Claim_Item_Detail_SubDetail[]? SubDetail { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.Money? UnitPrice { get; set; }
    }

    public class Claim_Item : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public string[]? DiagnosisSequence { get; set; }
        public string[]? ProcedureSequence { get; set; }
        public Base.Address? LocationAddress { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? Revenue { get; set; }
        public Base.ResourceReference[]? Encounter { get; set; }
        public Base.CodeableConcept? LocationCodeableConcept { get; set; }
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
        public Base.CodeableConcept[]? SubSite { get; set; }
        public string[]? CareTeamSequence { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public Base.ResourceReference? LocationReference { get; set; }
        public Base.ResourceReference[]? Udi { get; set; }
        public string[]? InformationSequence { get; set; }
        public Base.CodeableConcept[]? ProgramCode { get; set; }
        public string? Factor { get; set; }
        public string? ServicedDate { get; set; }
        public required string Sequence { get; set; }
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
        public Base.Money? UnitPrice { get; set; }
        public Base.Period? ServicedPeriod { get; set; }
        public Claim_Item_Detail[]? Detail { get; set; }
    }

    public class Claim_Procedure : BackboneElement
    {
        public Base.ResourceReference[]? Udi { get; set; }
        public string? Date { get; set; }
        public Base.CodeableConcept[]? Type { get; set; }
        public required string Sequence { get; set; }
        public object? Procedure    
        {
            get
            {
                if (ProcedureReference is not null)
                {
                    return ProcedureReference;
                }
        
                if (ProcedureCodeableConcept is not null)
                {
                    return ProcedureCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ProcedureReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ProcedureCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? ProcedureReference { get; set; }
        public Base.CodeableConcept? ProcedureCodeableConcept { get; set; }
    }

    public class Claim_Related : BackboneElement
    {
        public Base.ResourceReference? Claim { get; set; }
        public Base.Identifier? Reference { get; set; }
        public Base.CodeableConcept? Relationship { get; set; }
    }

    public class Claim_Accident : BackboneElement
    {
        public required string Date { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public object? Location    
        {
            get
            {
                if (LocationAddress is not null)
                {
                    return LocationAddress;
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
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    LocationReference = (Base.ResourceReference)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Address? LocationAddress { get; set; }
        public Base.ResourceReference? LocationReference { get; set; }
    }

    public class Claim_Payee : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public Base.ResourceReference? Party { get; set; }
    }

    public class Claim_CareTeam : BackboneElement
    {
        public Base.CodeableConcept? Role { get; set; }
        public required Base.ResourceReference Provider { get; set; }
        public required string Sequence { get; set; }
        public bool? Responsible { get; set; }
        public Base.CodeableConcept? Qualification { get; set; }
    }
}