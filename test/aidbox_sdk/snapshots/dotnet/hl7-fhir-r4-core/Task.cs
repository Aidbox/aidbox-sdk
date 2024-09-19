using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Task : DomainResource, IResource
{
    public Task_Restriction? Restriction { get; set; }
    public string? Description { get; set; }
    public Base.CodeableConcept[]? PerformerType { get; set; }
    public Base.Period? ExecutionPeriod { get; set; }
    public Base.ResourceReference[]? Insurance { get; set; }
    public string? InstantiatesCanonical { get; set; }
    public string? InstantiatesUri { get; set; }
    public Base.ResourceReference[]? RelevantHistory { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.CodeableConcept? ReasonCode { get; set; }
    public Base.CodeableConcept? StatusReason { get; set; }
    public string? AuthoredOn { get; set; }
    public Task_Output[]? Output { get; set; }
    public Base.CodeableConcept? BusinessStatus { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? For_ { get; set; }
    public Base.ResourceReference? Requester { get; set; }
    public string? LastModified { get; set; }
    public string? Priority { get; set; }
    public required string Status { get; set; }
    public Base.Identifier? GroupIdentifier { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required string Intent { get; set; }
    public Base.ResourceReference? Focus { get; set; }
    public Task_Input[]? Input { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public Base.ResourceReference? Location { get; set; }
    public Base.ResourceReference? Owner { get; set; }
    public Base.ResourceReference? ReasonReference { get; set; }

    public class Task_Restriction : BackboneElement
    {
        public Base.Period? Period { get; set; }
        public Base.ResourceReference[]? Recipient { get; set; }
        public string? Repetitions { get; set; }
    }

    public class Task_Output : BackboneElement
    {
        public string? ValueBase64Binary { get; set; }
        public string? ValueAge { get; set; }
        public Base.ParameterDefinition? ValueParameterDefinition { get; set; }
        public string? ValueTiming { get; set; }
        public string? ValueCode { get; set; }
        public Base.ResourceReference? ValueReference { get; set; }
        public Base.Contributor? ValueContributor { get; set; }
        public Base.ContactDetail? ValueContactDetail { get; set; }
        public string? ValueUri { get; set; }
        public Base.UsageContext? ValueUsageContext { get; set; }
        public string? ValueTime { get; set; }
        public string? ValueDecimal { get; set; }
        public string? ValueCanonical { get; set; }
        public string? ValueMarkdown { get; set; }
        public Base.Identifier? ValueIdentifier { get; set; }
        public Base.TriggerDefinition? ValueTriggerDefinition { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueBase64Binary is not null)
                {
                    return ValueBase64Binary;
                }
        
                if (ValueAge is not null)
                {
                    return ValueAge;
                }
        
                if (ValueParameterDefinition is not null)
                {
                    return ValueParameterDefinition;
                }
        
                if (ValueTiming is not null)
                {
                    return ValueTiming;
                }
        
                if (ValueCode is not null)
                {
                    return ValueCode;
                }
        
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueContributor is not null)
                {
                    return ValueContributor;
                }
        
                if (ValueContactDetail is not null)
                {
                    return ValueContactDetail;
                }
        
                if (ValueUri is not null)
                {
                    return ValueUri;
                }
        
                if (ValueUsageContext is not null)
                {
                    return ValueUsageContext;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
                }
        
                if (ValueCanonical is not null)
                {
                    return ValueCanonical;
                }
        
                if (ValueMarkdown is not null)
                {
                    return ValueMarkdown;
                }
        
                if (ValueIdentifier is not null)
                {
                    return ValueIdentifier;
                }
        
                if (ValueTriggerDefinition is not null)
                {
                    return ValueTriggerDefinition;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueCount is not null)
                {
                    return ValueCount;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueRatio is not null)
                {
                    return ValueRatio;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueInstant is not null)
                {
                    return ValueInstant;
                }
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueDuration is not null)
                {
                    return ValueDuration;
                }
        
                if (ValueDataRequirement is not null)
                {
                    return ValueDataRequirement;
                }
        
                if (ValueMeta is not null)
                {
                    return ValueMeta;
                }
        
                if (ValueMoney is not null)
                {
                    return ValueMoney;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueExpression is not null)
                {
                    return ValueExpression;
                }
        
                if (ValueSampledData is not null)
                {
                    return ValueSampledData;
                }
        
                if (ValueDosage is not null)
                {
                    return ValueDosage;
                }
        
                if (ValueContactPoint is not null)
                {
                    return ValueContactPoint;
                }
        
                if (ValueCodeableConcept is not null)
                {
                    return ValueCodeableConcept;
                }
        
                if (ValueAnnotation is not null)
                {
                    return ValueAnnotation;
                }
        
                if (ValuePeriod is not null)
                {
                    return ValuePeriod;
                }
        
                if (ValueDistance is not null)
                {
                    return ValueDistance;
                }
        
                if (ValueRange is not null)
                {
                    return ValueRange;
                }
        
                if (ValueSignature is not null)
                {
                    return ValueSignature;
                }
        
                if (ValueUuid is not null)
                {
                    return ValueUuid;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                if (ValueHumanName is not null)
                {
                    return ValueHumanName;
                }
        
                if (ValueUnsignedInt is not null)
                {
                    return ValueUnsignedInt;
                }
        
                if (ValueAttachment is not null)
                {
                    return ValueAttachment;
                }
        
                if (ValueOid is not null)
                {
                    return ValueOid;
                }
        
                if (ValueAddress is not null)
                {
                    return ValueAddress;
                }
        
                if (ValueRelatedArtifact is not null)
                {
                    return ValueRelatedArtifact;
                }
        
                if (ValuePositiveInt is not null)
                {
                    return ValuePositiveInt;
                }
        
                if (ValueId is not null)
                {
                    return ValueId;
                }
        
                if (ValueUrl is not null)
                {
                    return ValueUrl;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueBase64Binary = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueAge = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ParameterDefinition))
                {
                    ValueParameterDefinition = (Base.ParameterDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTiming = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueCode = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ValueReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Contributor))
                {
                    ValueContributor = (Base.Contributor)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactDetail))
                {
                    ValueContactDetail = (Base.ContactDetail)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.UsageContext))
                {
                    ValueUsageContext = (Base.UsageContext)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueCanonical = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueMarkdown = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Identifier))
                {
                    ValueIdentifier = (Base.Identifier)value;return;
                }
        
                if (value?.GetType() == typeof(Base.TriggerDefinition))
                {
                    ValueTriggerDefinition = (Base.TriggerDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueCount = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    ValueRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueInstant = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDuration = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.DataRequirement))
                {
                    ValueDataRequirement = (Base.DataRequirement)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Meta))
                {
                    ValueMeta = (Base.Meta)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Money))
                {
                    ValueMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceExpression))
                {
                    ValueExpression = (Base.ResourceExpression)value;return;
                }
        
                if (value?.GetType() == typeof(Base.SampledData))
                {
                    ValueSampledData = (Base.SampledData)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDosage = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactPoint))
                {
                    ValueContactPoint = (Base.ContactPoint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ValueCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Annotation))
                {
                    ValueAnnotation = (Base.Annotation)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    ValuePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDistance = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    ValueRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Signature))
                {
                    ValueSignature = (Base.Signature)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUuid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(Base.HumanName))
                {
                    ValueHumanName = (Base.HumanName)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    ValueUnsignedInt = (uint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    ValueAttachment = (Base.Attachment)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueOid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Address))
                {
                    ValueAddress = (Base.Address)value;return;
                }
        
                if (value?.GetType() == typeof(Base.RelatedArtifact))
                {
                    ValueRelatedArtifact = (Base.RelatedArtifact)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValuePositiveInt = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueId = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUrl = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueCount { get; set; }
        public string? ValueString { get; set; }
        public Base.Ratio? ValueRatio { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueInstant { get; set; }
        public string? ValueDateTime { get; set; }
        public string? ValueDate { get; set; }
        public required Base.CodeableConcept Type { get; set; }
        public string? ValueDuration { get; set; }
        public Base.DataRequirement? ValueDataRequirement { get; set; }
        public Base.Meta? ValueMeta { get; set; }
        public Base.Money? ValueMoney { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public Base.ResourceExpression? ValueExpression { get; set; }
        public Base.SampledData? ValueSampledData { get; set; }
        public string? ValueDosage { get; set; }
        public Base.ContactPoint? ValueContactPoint { get; set; }
        public Base.CodeableConcept? ValueCodeableConcept { get; set; }
        public Base.Annotation? ValueAnnotation { get; set; }
        public Base.Period? ValuePeriod { get; set; }
        public string? ValueDistance { get; set; }
        public Base.Range? ValueRange { get; set; }
        public Base.Signature? ValueSignature { get; set; }
        public string? ValueUuid { get; set; }
        public int? ValueInteger { get; set; }
        public Base.HumanName? ValueHumanName { get; set; }
        public uint? ValueUnsignedInt { get; set; }
        public Base.Attachment? ValueAttachment { get; set; }
        public string? ValueOid { get; set; }
        public Base.Address? ValueAddress { get; set; }
        public Base.RelatedArtifact? ValueRelatedArtifact { get; set; }
        public string? ValuePositiveInt { get; set; }
        public string? ValueId { get; set; }
        public string? ValueUrl { get; set; }
    }

    public class Task_Input : BackboneElement
    {
        public string? ValueBase64Binary { get; set; }
        public string? ValueAge { get; set; }
        public Base.ParameterDefinition? ValueParameterDefinition { get; set; }
        public string? ValueTiming { get; set; }
        public string? ValueCode { get; set; }
        public Base.ResourceReference? ValueReference { get; set; }
        public Base.Contributor? ValueContributor { get; set; }
        public Base.ContactDetail? ValueContactDetail { get; set; }
        public string? ValueUri { get; set; }
        public Base.UsageContext? ValueUsageContext { get; set; }
        public string? ValueTime { get; set; }
        public string? ValueDecimal { get; set; }
        public string? ValueCanonical { get; set; }
        public string? ValueMarkdown { get; set; }
        public Base.Identifier? ValueIdentifier { get; set; }
        public Base.TriggerDefinition? ValueTriggerDefinition { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueBase64Binary is not null)
                {
                    return ValueBase64Binary;
                }
        
                if (ValueAge is not null)
                {
                    return ValueAge;
                }
        
                if (ValueParameterDefinition is not null)
                {
                    return ValueParameterDefinition;
                }
        
                if (ValueTiming is not null)
                {
                    return ValueTiming;
                }
        
                if (ValueCode is not null)
                {
                    return ValueCode;
                }
        
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueContributor is not null)
                {
                    return ValueContributor;
                }
        
                if (ValueContactDetail is not null)
                {
                    return ValueContactDetail;
                }
        
                if (ValueUri is not null)
                {
                    return ValueUri;
                }
        
                if (ValueUsageContext is not null)
                {
                    return ValueUsageContext;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
                }
        
                if (ValueCanonical is not null)
                {
                    return ValueCanonical;
                }
        
                if (ValueMarkdown is not null)
                {
                    return ValueMarkdown;
                }
        
                if (ValueIdentifier is not null)
                {
                    return ValueIdentifier;
                }
        
                if (ValueTriggerDefinition is not null)
                {
                    return ValueTriggerDefinition;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueCount is not null)
                {
                    return ValueCount;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueRatio is not null)
                {
                    return ValueRatio;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueInstant is not null)
                {
                    return ValueInstant;
                }
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueDuration is not null)
                {
                    return ValueDuration;
                }
        
                if (ValueDataRequirement is not null)
                {
                    return ValueDataRequirement;
                }
        
                if (ValueMeta is not null)
                {
                    return ValueMeta;
                }
        
                if (ValueMoney is not null)
                {
                    return ValueMoney;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueExpression is not null)
                {
                    return ValueExpression;
                }
        
                if (ValueSampledData is not null)
                {
                    return ValueSampledData;
                }
        
                if (ValueDosage is not null)
                {
                    return ValueDosage;
                }
        
                if (ValueContactPoint is not null)
                {
                    return ValueContactPoint;
                }
        
                if (ValueCodeableConcept is not null)
                {
                    return ValueCodeableConcept;
                }
        
                if (ValueAnnotation is not null)
                {
                    return ValueAnnotation;
                }
        
                if (ValuePeriod is not null)
                {
                    return ValuePeriod;
                }
        
                if (ValueDistance is not null)
                {
                    return ValueDistance;
                }
        
                if (ValueRange is not null)
                {
                    return ValueRange;
                }
        
                if (ValueSignature is not null)
                {
                    return ValueSignature;
                }
        
                if (ValueUuid is not null)
                {
                    return ValueUuid;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                if (ValueHumanName is not null)
                {
                    return ValueHumanName;
                }
        
                if (ValueUnsignedInt is not null)
                {
                    return ValueUnsignedInt;
                }
        
                if (ValueAttachment is not null)
                {
                    return ValueAttachment;
                }
        
                if (ValueOid is not null)
                {
                    return ValueOid;
                }
        
                if (ValueAddress is not null)
                {
                    return ValueAddress;
                }
        
                if (ValueRelatedArtifact is not null)
                {
                    return ValueRelatedArtifact;
                }
        
                if (ValuePositiveInt is not null)
                {
                    return ValuePositiveInt;
                }
        
                if (ValueId is not null)
                {
                    return ValueId;
                }
        
                if (ValueUrl is not null)
                {
                    return ValueUrl;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueBase64Binary = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueAge = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ParameterDefinition))
                {
                    ValueParameterDefinition = (Base.ParameterDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTiming = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueCode = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ValueReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Contributor))
                {
                    ValueContributor = (Base.Contributor)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactDetail))
                {
                    ValueContactDetail = (Base.ContactDetail)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.UsageContext))
                {
                    ValueUsageContext = (Base.UsageContext)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueCanonical = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueMarkdown = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Identifier))
                {
                    ValueIdentifier = (Base.Identifier)value;return;
                }
        
                if (value?.GetType() == typeof(Base.TriggerDefinition))
                {
                    ValueTriggerDefinition = (Base.TriggerDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueCount = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    ValueRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueInstant = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDuration = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.DataRequirement))
                {
                    ValueDataRequirement = (Base.DataRequirement)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Meta))
                {
                    ValueMeta = (Base.Meta)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Money))
                {
                    ValueMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceExpression))
                {
                    ValueExpression = (Base.ResourceExpression)value;return;
                }
        
                if (value?.GetType() == typeof(Base.SampledData))
                {
                    ValueSampledData = (Base.SampledData)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDosage = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactPoint))
                {
                    ValueContactPoint = (Base.ContactPoint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ValueCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Annotation))
                {
                    ValueAnnotation = (Base.Annotation)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    ValuePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDistance = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    ValueRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Signature))
                {
                    ValueSignature = (Base.Signature)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUuid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(Base.HumanName))
                {
                    ValueHumanName = (Base.HumanName)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    ValueUnsignedInt = (uint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    ValueAttachment = (Base.Attachment)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueOid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Address))
                {
                    ValueAddress = (Base.Address)value;return;
                }
        
                if (value?.GetType() == typeof(Base.RelatedArtifact))
                {
                    ValueRelatedArtifact = (Base.RelatedArtifact)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValuePositiveInt = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueId = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUrl = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueCount { get; set; }
        public string? ValueString { get; set; }
        public Base.Ratio? ValueRatio { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueInstant { get; set; }
        public string? ValueDateTime { get; set; }
        public string? ValueDate { get; set; }
        public required Base.CodeableConcept Type { get; set; }
        public string? ValueDuration { get; set; }
        public Base.DataRequirement? ValueDataRequirement { get; set; }
        public Base.Meta? ValueMeta { get; set; }
        public Base.Money? ValueMoney { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public Base.ResourceExpression? ValueExpression { get; set; }
        public Base.SampledData? ValueSampledData { get; set; }
        public string? ValueDosage { get; set; }
        public Base.ContactPoint? ValueContactPoint { get; set; }
        public Base.CodeableConcept? ValueCodeableConcept { get; set; }
        public Base.Annotation? ValueAnnotation { get; set; }
        public Base.Period? ValuePeriod { get; set; }
        public string? ValueDistance { get; set; }
        public Base.Range? ValueRange { get; set; }
        public Base.Signature? ValueSignature { get; set; }
        public string? ValueUuid { get; set; }
        public int? ValueInteger { get; set; }
        public Base.HumanName? ValueHumanName { get; set; }
        public uint? ValueUnsignedInt { get; set; }
        public Base.Attachment? ValueAttachment { get; set; }
        public string? ValueOid { get; set; }
        public Base.Address? ValueAddress { get; set; }
        public Base.RelatedArtifact? ValueRelatedArtifact { get; set; }
        public string? ValuePositiveInt { get; set; }
        public string? ValueId { get; set; }
        public string? ValueUrl { get; set; }
    }
}