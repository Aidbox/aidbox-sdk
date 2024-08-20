using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ExplanationOfBenefit : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public Base.ResourceReference? ClaimResponse { get; set; }
    public required ExplanationOfBenefit_Insurance[] Insurance { get; set; }
    public ExplanationOfBenefit_BenefitBalance[]? BenefitBalance { get; set; }
    public Base.ResourceReference? Facility { get; set; }
    public ExplanationOfBenefit_ProcessNote[]? ProcessNote { get; set; }
    public ExplanationOfBenefit_Diagnosis[]? Diagnosis { get; set; }
    public string[]? PreAuthRef { get; set; }
    public ExplanationOfBenefit_Adjudication[]? Adjudication { get; set; }
    public Base.ResourceReference? Enterer { get; set; }
    public ExplanationOfBenefit_SupportingInfo[]? SupportingInfo { get; set; }
    public required string Use { get; set; }
    public ExplanationOfBenefit_Payment? Payment { get; set; }
    public ExplanationOfBenefit_Item[]? Item { get; set; }
    public required Base.CodeableConcept Type { get; set; }
    public required string Created { get; set; }
    public ExplanationOfBenefit_Procedure[]? Procedure { get; set; }
    public required string Outcome { get; set; }
    public ExplanationOfBenefit_Related[]? Related { get; set; }
    public string? Disposition { get; set; }
    public Base.ResourceReference? Referral { get; set; }
    public Base.Period[]? PreAuthRefPeriod { get; set; }
    public ExplanationOfBenefit_Total[]? Total { get; set; }
    public required Base.ResourceReference Insurer { get; set; }
    public Base.CodeableConcept? FundsReserve { get; set; }
    public Base.CodeableConcept? Priority { get; set; }
    public ExplanationOfBenefit_Accident? Accident { get; set; }
    public required string Status { get; set; }
    public ExplanationOfBenefit_Payee? Payee { get; set; }
    public Base.ResourceReference? Prescription { get; set; }
    public Base.Period? BillablePeriod { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.Attachment? Form { get; set; }
    public Base.CodeableConcept? SubType { get; set; }
    public Base.CodeableConcept? FundsReserveRequested { get; set; }
    public Base.Period? BenefitPeriod { get; set; }
    public string? Precedence { get; set; }
    public Base.CodeableConcept? FormCode { get; set; }
    public required Base.ResourceReference Provider { get; set; }
    public ExplanationOfBenefit_AddItem[]? AddItem { get; set; }
    public Base.ResourceReference? OriginalPrescription { get; set; }
    public ExplanationOfBenefit_CareTeam[]? CareTeam { get; set; }
    public Base.ResourceReference? Claim { get; set; }

    public class ExplanationOfBenefit_Insurance : BackboneElement
    {
        public required bool Focal { get; set; }
        public required Base.ResourceReference Coverage { get; set; }
        public string[]? PreAuthRef { get; set; }
    }

    public class ExplanationOfBenefit_BenefitBalance_Financial : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public object? Used    
        {
            get
            {
                if (UsedMoney is not null)
                {
                    return UsedMoney;
                }
        
                if (UsedUnsignedInt is not null)
                {
                    return UsedUnsignedInt;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Money))
                {
                    UsedMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    UsedUnsignedInt = (uint)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public object? Allowed    
        {
            get
            {
                if (AllowedMoney is not null)
                {
                    return AllowedMoney;
                }
        
                if (AllowedString is not null)
                {
                    return AllowedString;
                }
        
                if (AllowedUnsignedInt is not null)
                {
                    return AllowedUnsignedInt;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Money))
                {
                    AllowedMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AllowedString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    AllowedUnsignedInt = (uint)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Money? UsedMoney { get; set; }
        public Base.Money? AllowedMoney { get; set; }
        public string? AllowedString { get; set; }
        public uint? UsedUnsignedInt { get; set; }
        public uint? AllowedUnsignedInt { get; set; }
    }

    public class ExplanationOfBenefit_BenefitBalance : BackboneElement
    {
        public string? Name { get; set; }
        public Base.CodeableConcept? Term { get; set; }
        public Base.CodeableConcept? Unit { get; set; }
        public Base.CodeableConcept? Network { get; set; }
        public required Base.CodeableConcept Category { get; set; }
        public bool? Excluded { get; set; }
        public ExplanationOfBenefit_BenefitBalance_Financial[]? Financial { get; set; }
        public string? Description { get; set; }
    }

    public class ExplanationOfBenefit_ProcessNote : BackboneElement
    {
        public string? Text { get; set; }
        public string? Type { get; set; }
        public string? Number { get; set; }
        public Base.CodeableConcept? Language { get; set; }
    }

    public class ExplanationOfBenefit_Diagnosis : BackboneElement
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

    public class ExplanationOfBenefit_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_SupportingInfo : BackboneElement
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
        public Base.Coding? Reason { get; set; }
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

    public class ExplanationOfBenefit_Payment : BackboneElement
    {
        public string? Date { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.Money? Adjustment { get; set; }
        public Base.Identifier? Identifier { get; set; }
        public Base.CodeableConcept? AdjustmentReason { get; set; }
    }

    public class ExplanationOfBenefit_Item_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_Item_Detail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_Item_Detail_SubDetail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_Item_Detail_SubDetail : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? Revenue { get; set; }
        public ExplanationOfBenefit_Item_Detail_SubDetail_Adjudication[]? Adjudication { get; set; }
        public Base.Money? Net { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public Base.ResourceReference[]? Udi { get; set; }
        public Base.CodeableConcept[]? ProgramCode { get; set; }
        public string? Factor { get; set; }
        public required string Sequence { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public string[]? NoteNumber { get; set; }
        public Base.Money? UnitPrice { get; set; }
    }

    public class ExplanationOfBenefit_Item_Detail : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? Revenue { get; set; }
        public ExplanationOfBenefit_Item_Detail_Adjudication[]? Adjudication { get; set; }
        public Base.Money? Net { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public Base.ResourceReference[]? Udi { get; set; }
        public Base.CodeableConcept[]? ProgramCode { get; set; }
        public string? Factor { get; set; }
        public required string Sequence { get; set; }
        public ExplanationOfBenefit_Item_Detail_SubDetail[]? SubDetail { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public string[]? NoteNumber { get; set; }
        public Base.Money? UnitPrice { get; set; }
    }

    public class ExplanationOfBenefit_Item : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public string[]? DiagnosisSequence { get; set; }
        public string[]? ProcedureSequence { get; set; }
        public Base.Address? LocationAddress { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? Revenue { get; set; }
        public ExplanationOfBenefit_Item_Adjudication[]? Adjudication { get; set; }
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
        public string[]? NoteNumber { get; set; }
        public Base.Money? UnitPrice { get; set; }
        public Base.Period? ServicedPeriod { get; set; }
        public ExplanationOfBenefit_Item_Detail[]? Detail { get; set; }
    }

    public class ExplanationOfBenefit_Procedure : BackboneElement
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

    public class ExplanationOfBenefit_Related : BackboneElement
    {
        public Base.ResourceReference? Claim { get; set; }
        public Base.Identifier? Reference { get; set; }
        public Base.CodeableConcept? Relationship { get; set; }
    }

    public class ExplanationOfBenefit_Total : BackboneElement
    {
        public required Base.Money Amount { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_Accident : BackboneElement
    {
        public string? Date { get; set; }
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

    public class ExplanationOfBenefit_Payee : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference? Party { get; set; }
    }

    public class ExplanationOfBenefit_AddItem_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_AddItem_Detail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_AddItem_Detail_SubDetail_Adjudication : BackboneElement
    {
        public string? Value { get; set; }
        public Base.Money? Amount { get; set; }
        public Base.CodeableConcept? Reason { get; set; }
        public required Base.CodeableConcept Category { get; set; }
    }

    public class ExplanationOfBenefit_AddItem_Detail_SubDetail : BackboneElement
    {
        public Base.Money? Net { get; set; }
        public string? Factor { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.Money? UnitPrice { get; set; }
        public string[]? NoteNumber { get; set; }
        public ExplanationOfBenefit_AddItem_Detail_SubDetail_Adjudication[]? Adjudication { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
    }

    public class ExplanationOfBenefit_AddItem_Detail : BackboneElement
    {
        public Base.CodeableConcept[]? Modifier { get; set; }
        public ExplanationOfBenefit_AddItem_Detail_Adjudication[]? Adjudication { get; set; }
        public Base.Money? Net { get; set; }
        public required Base.CodeableConcept ProductOrService { get; set; }
        public string? Factor { get; set; }
        public ExplanationOfBenefit_AddItem_Detail_SubDetail[]? SubDetail { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public string[]? NoteNumber { get; set; }
        public Base.Money? UnitPrice { get; set; }
    }

    public class ExplanationOfBenefit_AddItem : BackboneElement
    {
        public Base.Address? LocationAddress { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public ExplanationOfBenefit_AddItem_Adjudication[]? Adjudication { get; set; }
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
        public string[]? SubDetailSequence { get; set; }
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
        public ExplanationOfBenefit_AddItem_Detail[]? Detail { get; set; }
    }

    public class ExplanationOfBenefit_CareTeam : BackboneElement
    {
        public Base.CodeableConcept? Role { get; set; }
        public required Base.ResourceReference Provider { get; set; }
        public required string Sequence { get; set; }
        public bool? Responsible { get; set; }
        public Base.CodeableConcept? Qualification { get; set; }
    }
}