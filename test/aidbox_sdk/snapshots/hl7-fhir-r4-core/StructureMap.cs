using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class StructureMap : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public required StructureMap_Group[] Group { get; set; }
    public string? Publisher { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public required string Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public string? Title { get; set; }
    public StructureMap_Structure[]? Structure { get; set; }
    public required string Status { get; set; }
    public required string Url { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? Version { get; set; }
    public string[]? Import_ { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }

    public class StructureMap_Group_Rule_Rule_Source : BackboneElement
    {
        public string? DefaultValueTime { get; set; }
        public Base.DataRequirement? DefaultValueDataRequirement { get; set; }
        public int? Min { get; set; }
        public Base.Money? DefaultValueMoney { get; set; }
        public Base.ContactPoint? DefaultValueContactPoint { get; set; }
        public Base.Meta? DefaultValueMeta { get; set; }
        public Base.Coding? DefaultValueCoding { get; set; }
        public string? Variable { get; set; }
        public string? DefaultValueCode { get; set; }
        public string? Element { get; set; }
        public Base.SampledData? DefaultValueSampledData { get; set; }
        public string? DefaultValueMarkdown { get; set; }
        public Base.HumanName? DefaultValueHumanName { get; set; }
        public string? DefaultValueDuration { get; set; }
        public string? DefaultValueDecimal { get; set; }
        public string? DefaultValueUri { get; set; }
        public string? Check { get; set; }
        public Base.Quantity? DefaultValueQuantity { get; set; }
        public string? DefaultValueCount { get; set; }
        public string? DefaultValueId { get; set; }
        public string? DefaultValueBase64Binary { get; set; }
        public Base.ContactDetail? DefaultValueContactDetail { get; set; }
        public string? Type { get; set; }
        public bool? DefaultValueBoolean { get; set; }
        public Base.Period? DefaultValuePeriod { get; set; }
        public Base.TriggerDefinition? DefaultValueTriggerDefinition { get; set; }
        public string? LogMessage { get; set; }
        public string? DefaultValueDate { get; set; }
        public Base.ResourceReference? DefaultValueReference { get; set; }
        public string? DefaultValueDosage { get; set; }
        public Base.Range? DefaultValueRange { get; set; }
        public string? DefaultValueInstant { get; set; }
        public Base.Attachment? DefaultValueAttachment { get; set; }
        public uint? DefaultValueUnsignedInt { get; set; }
        public string? DefaultValueDistance { get; set; }
        public string? Max { get; set; }
        public Base.Contributor? DefaultValueContributor { get; set; }
        public string? Condition { get; set; }
        public Base.Ratio? DefaultValueRatio { get; set; }
        public string? DefaultValueCanonical { get; set; }
        public Base.ResourceExpression? DefaultValueExpression { get; set; }
        public Base.Signature? DefaultValueSignature { get; set; }
        public string? DefaultValueUrl { get; set; }
        public required string Context { get; set; }
        public Base.Annotation? DefaultValueAnnotation { get; set; }
        public string? DefaultValueUuid { get; set; }
        public Base.Address? DefaultValueAddress { get; set; }
        public string? DefaultValueString { get; set; }
        public string? DefaultValueAge { get; set; }
        public string? DefaultValueOid { get; set; }
        public Base.UsageContext? DefaultValueUsageContext { get; set; }
        public string? ListMode { get; set; }
        public object? DefaultValue    
        {
            get
            {
                if (DefaultValueTime is not null)
                {
                    return DefaultValueTime;
                }
        
                if (DefaultValueDataRequirement is not null)
                {
                    return DefaultValueDataRequirement;
                }
        
                if (DefaultValueMoney is not null)
                {
                    return DefaultValueMoney;
                }
        
                if (DefaultValueContactPoint is not null)
                {
                    return DefaultValueContactPoint;
                }
        
                if (DefaultValueMeta is not null)
                {
                    return DefaultValueMeta;
                }
        
                if (DefaultValueCoding is not null)
                {
                    return DefaultValueCoding;
                }
        
                if (DefaultValueCode is not null)
                {
                    return DefaultValueCode;
                }
        
                if (DefaultValueSampledData is not null)
                {
                    return DefaultValueSampledData;
                }
        
                if (DefaultValueMarkdown is not null)
                {
                    return DefaultValueMarkdown;
                }
        
                if (DefaultValueHumanName is not null)
                {
                    return DefaultValueHumanName;
                }
        
                if (DefaultValueDuration is not null)
                {
                    return DefaultValueDuration;
                }
        
                if (DefaultValueDecimal is not null)
                {
                    return DefaultValueDecimal;
                }
        
                if (DefaultValueUri is not null)
                {
                    return DefaultValueUri;
                }
        
                if (DefaultValueQuantity is not null)
                {
                    return DefaultValueQuantity;
                }
        
                if (DefaultValueCount is not null)
                {
                    return DefaultValueCount;
                }
        
                if (DefaultValueId is not null)
                {
                    return DefaultValueId;
                }
        
                if (DefaultValueBase64Binary is not null)
                {
                    return DefaultValueBase64Binary;
                }
        
                if (DefaultValueContactDetail is not null)
                {
                    return DefaultValueContactDetail;
                }
        
                if (DefaultValueBoolean is not null)
                {
                    return DefaultValueBoolean;
                }
        
                if (DefaultValuePeriod is not null)
                {
                    return DefaultValuePeriod;
                }
        
                if (DefaultValueTriggerDefinition is not null)
                {
                    return DefaultValueTriggerDefinition;
                }
        
                if (DefaultValueDate is not null)
                {
                    return DefaultValueDate;
                }
        
                if (DefaultValueReference is not null)
                {
                    return DefaultValueReference;
                }
        
                if (DefaultValueDosage is not null)
                {
                    return DefaultValueDosage;
                }
        
                if (DefaultValueRange is not null)
                {
                    return DefaultValueRange;
                }
        
                if (DefaultValueInstant is not null)
                {
                    return DefaultValueInstant;
                }
        
                if (DefaultValueAttachment is not null)
                {
                    return DefaultValueAttachment;
                }
        
                if (DefaultValueUnsignedInt is not null)
                {
                    return DefaultValueUnsignedInt;
                }
        
                if (DefaultValueDistance is not null)
                {
                    return DefaultValueDistance;
                }
        
                if (DefaultValueContributor is not null)
                {
                    return DefaultValueContributor;
                }
        
                if (DefaultValueRatio is not null)
                {
                    return DefaultValueRatio;
                }
        
                if (DefaultValueCanonical is not null)
                {
                    return DefaultValueCanonical;
                }
        
                if (DefaultValueExpression is not null)
                {
                    return DefaultValueExpression;
                }
        
                if (DefaultValueSignature is not null)
                {
                    return DefaultValueSignature;
                }
        
                if (DefaultValueUrl is not null)
                {
                    return DefaultValueUrl;
                }
        
                if (DefaultValueAnnotation is not null)
                {
                    return DefaultValueAnnotation;
                }
        
                if (DefaultValueUuid is not null)
                {
                    return DefaultValueUuid;
                }
        
                if (DefaultValueAddress is not null)
                {
                    return DefaultValueAddress;
                }
        
                if (DefaultValueString is not null)
                {
                    return DefaultValueString;
                }
        
                if (DefaultValueAge is not null)
                {
                    return DefaultValueAge;
                }
        
                if (DefaultValueOid is not null)
                {
                    return DefaultValueOid;
                }
        
                if (DefaultValueUsageContext is not null)
                {
                    return DefaultValueUsageContext;
                }
        
                if (DefaultValueParameterDefinition is not null)
                {
                    return DefaultValueParameterDefinition;
                }
        
                if (DefaultValueDateTime is not null)
                {
                    return DefaultValueDateTime;
                }
        
                if (DefaultValuePositiveInt is not null)
                {
                    return DefaultValuePositiveInt;
                }
        
                if (DefaultValueInteger is not null)
                {
                    return DefaultValueInteger;
                }
        
                if (DefaultValueTiming is not null)
                {
                    return DefaultValueTiming;
                }
        
                if (DefaultValueRelatedArtifact is not null)
                {
                    return DefaultValueRelatedArtifact;
                }
        
                if (DefaultValueIdentifier is not null)
                {
                    return DefaultValueIdentifier;
                }
        
                if (DefaultValueCodeableConcept is not null)
                {
                    return DefaultValueCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.DataRequirement))
                {
                    DefaultValueDataRequirement = (Base.DataRequirement)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Money))
                {
                    DefaultValueMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactPoint))
                {
                    DefaultValueContactPoint = (Base.ContactPoint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Meta))
                {
                    DefaultValueMeta = (Base.Meta)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    DefaultValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueCode = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.SampledData))
                {
                    DefaultValueSampledData = (Base.SampledData)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueMarkdown = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.HumanName))
                {
                    DefaultValueHumanName = (Base.HumanName)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDuration = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    DefaultValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueCount = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueId = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueBase64Binary = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactDetail))
                {
                    DefaultValueContactDetail = (Base.ContactDetail)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    DefaultValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    DefaultValuePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(Base.TriggerDefinition))
                {
                    DefaultValueTriggerDefinition = (Base.TriggerDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    DefaultValueReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDosage = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    DefaultValueRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueInstant = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    DefaultValueAttachment = (Base.Attachment)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    DefaultValueUnsignedInt = (uint)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDistance = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Contributor))
                {
                    DefaultValueContributor = (Base.Contributor)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    DefaultValueRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueCanonical = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceExpression))
                {
                    DefaultValueExpression = (Base.ResourceExpression)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Signature))
                {
                    DefaultValueSignature = (Base.Signature)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueUrl = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Annotation))
                {
                    DefaultValueAnnotation = (Base.Annotation)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueUuid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Address))
                {
                    DefaultValueAddress = (Base.Address)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueAge = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueOid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.UsageContext))
                {
                    DefaultValueUsageContext = (Base.UsageContext)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ParameterDefinition))
                {
                    DefaultValueParameterDefinition = (Base.ParameterDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValuePositiveInt = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    DefaultValueInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueTiming = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.RelatedArtifact))
                {
                    DefaultValueRelatedArtifact = (Base.RelatedArtifact)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Identifier))
                {
                    DefaultValueIdentifier = (Base.Identifier)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DefaultValueCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ParameterDefinition? DefaultValueParameterDefinition { get; set; }
        public string? DefaultValueDateTime { get; set; }
        public string? DefaultValuePositiveInt { get; set; }
        public int? DefaultValueInteger { get; set; }
        public string? DefaultValueTiming { get; set; }
        public Base.RelatedArtifact? DefaultValueRelatedArtifact { get; set; }
        public Base.Identifier? DefaultValueIdentifier { get; set; }
        public Base.CodeableConcept? DefaultValueCodeableConcept { get; set; }
    }

    public class StructureMap_Group_Rule_Rule_Target_Parameter : BackboneElement
    {
        public object? Value    
        {
            get
            {
                if (ValueId is not null)
                {
                    return ValueId;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueId = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueId { get; set; }
        public string? ValueString { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueDecimal { get; set; }
        public int? ValueInteger { get; set; }
    }

    public class StructureMap_Group_Rule_Rule_Target : BackboneElement
    {
        public string? Context { get; set; }
        public string? Element { get; set; }
        public string[]? ListMode { get; set; }
        public string? Variable { get; set; }
        public StructureMap_Group_Rule_Rule_Target_Parameter[]? Parameter { get; set; }
        public string? Transform { get; set; }
        public string? ListRuleId { get; set; }
        public string? ContextType { get; set; }
    }

    public class StructureMap_Group_Rule_Rule_Dependent : BackboneElement
    {
        public required string Name { get; set; }
        public required string[] Variable { get; set; }
    }

    public class StructureMap_Group_Rule_Rule : BackboneElement
    {
        public required string Name { get; set; }
        public string[]? Rule { get; set; }
        public required StructureMap_Group_Rule_Rule_Source[] Source { get; set; }
        public StructureMap_Group_Rule_Rule_Target[]? Target { get; set; }
        public StructureMap_Group_Rule_Rule_Dependent[]? Dependent { get; set; }
        public string? Documentation { get; set; }
    }

    public class StructureMap_Group_Rule_Source : BackboneElement
    {
        public string? DefaultValueTime { get; set; }
        public Base.DataRequirement? DefaultValueDataRequirement { get; set; }
        public int? Min { get; set; }
        public Base.Money? DefaultValueMoney { get; set; }
        public Base.ContactPoint? DefaultValueContactPoint { get; set; }
        public Base.Meta? DefaultValueMeta { get; set; }
        public Base.Coding? DefaultValueCoding { get; set; }
        public string? Variable { get; set; }
        public string? DefaultValueCode { get; set; }
        public string? Element { get; set; }
        public Base.SampledData? DefaultValueSampledData { get; set; }
        public string? DefaultValueMarkdown { get; set; }
        public Base.HumanName? DefaultValueHumanName { get; set; }
        public string? DefaultValueDuration { get; set; }
        public string? DefaultValueDecimal { get; set; }
        public string? DefaultValueUri { get; set; }
        public string? Check { get; set; }
        public Base.Quantity? DefaultValueQuantity { get; set; }
        public string? DefaultValueCount { get; set; }
        public string? DefaultValueId { get; set; }
        public string? DefaultValueBase64Binary { get; set; }
        public Base.ContactDetail? DefaultValueContactDetail { get; set; }
        public string? Type { get; set; }
        public bool? DefaultValueBoolean { get; set; }
        public Base.Period? DefaultValuePeriod { get; set; }
        public Base.TriggerDefinition? DefaultValueTriggerDefinition { get; set; }
        public string? LogMessage { get; set; }
        public string? DefaultValueDate { get; set; }
        public Base.ResourceReference? DefaultValueReference { get; set; }
        public string? DefaultValueDosage { get; set; }
        public Base.Range? DefaultValueRange { get; set; }
        public string? DefaultValueInstant { get; set; }
        public Base.Attachment? DefaultValueAttachment { get; set; }
        public uint? DefaultValueUnsignedInt { get; set; }
        public string? DefaultValueDistance { get; set; }
        public string? Max { get; set; }
        public Base.Contributor? DefaultValueContributor { get; set; }
        public string? Condition { get; set; }
        public Base.Ratio? DefaultValueRatio { get; set; }
        public string? DefaultValueCanonical { get; set; }
        public Base.ResourceExpression? DefaultValueExpression { get; set; }
        public Base.Signature? DefaultValueSignature { get; set; }
        public string? DefaultValueUrl { get; set; }
        public required string Context { get; set; }
        public Base.Annotation? DefaultValueAnnotation { get; set; }
        public string? DefaultValueUuid { get; set; }
        public Base.Address? DefaultValueAddress { get; set; }
        public string? DefaultValueString { get; set; }
        public string? DefaultValueAge { get; set; }
        public string? DefaultValueOid { get; set; }
        public Base.UsageContext? DefaultValueUsageContext { get; set; }
        public string? ListMode { get; set; }
        public object? DefaultValue    
        {
            get
            {
                if (DefaultValueTime is not null)
                {
                    return DefaultValueTime;
                }
        
                if (DefaultValueDataRequirement is not null)
                {
                    return DefaultValueDataRequirement;
                }
        
                if (DefaultValueMoney is not null)
                {
                    return DefaultValueMoney;
                }
        
                if (DefaultValueContactPoint is not null)
                {
                    return DefaultValueContactPoint;
                }
        
                if (DefaultValueMeta is not null)
                {
                    return DefaultValueMeta;
                }
        
                if (DefaultValueCoding is not null)
                {
                    return DefaultValueCoding;
                }
        
                if (DefaultValueCode is not null)
                {
                    return DefaultValueCode;
                }
        
                if (DefaultValueSampledData is not null)
                {
                    return DefaultValueSampledData;
                }
        
                if (DefaultValueMarkdown is not null)
                {
                    return DefaultValueMarkdown;
                }
        
                if (DefaultValueHumanName is not null)
                {
                    return DefaultValueHumanName;
                }
        
                if (DefaultValueDuration is not null)
                {
                    return DefaultValueDuration;
                }
        
                if (DefaultValueDecimal is not null)
                {
                    return DefaultValueDecimal;
                }
        
                if (DefaultValueUri is not null)
                {
                    return DefaultValueUri;
                }
        
                if (DefaultValueQuantity is not null)
                {
                    return DefaultValueQuantity;
                }
        
                if (DefaultValueCount is not null)
                {
                    return DefaultValueCount;
                }
        
                if (DefaultValueId is not null)
                {
                    return DefaultValueId;
                }
        
                if (DefaultValueBase64Binary is not null)
                {
                    return DefaultValueBase64Binary;
                }
        
                if (DefaultValueContactDetail is not null)
                {
                    return DefaultValueContactDetail;
                }
        
                if (DefaultValueBoolean is not null)
                {
                    return DefaultValueBoolean;
                }
        
                if (DefaultValuePeriod is not null)
                {
                    return DefaultValuePeriod;
                }
        
                if (DefaultValueTriggerDefinition is not null)
                {
                    return DefaultValueTriggerDefinition;
                }
        
                if (DefaultValueDate is not null)
                {
                    return DefaultValueDate;
                }
        
                if (DefaultValueReference is not null)
                {
                    return DefaultValueReference;
                }
        
                if (DefaultValueDosage is not null)
                {
                    return DefaultValueDosage;
                }
        
                if (DefaultValueRange is not null)
                {
                    return DefaultValueRange;
                }
        
                if (DefaultValueInstant is not null)
                {
                    return DefaultValueInstant;
                }
        
                if (DefaultValueAttachment is not null)
                {
                    return DefaultValueAttachment;
                }
        
                if (DefaultValueUnsignedInt is not null)
                {
                    return DefaultValueUnsignedInt;
                }
        
                if (DefaultValueDistance is not null)
                {
                    return DefaultValueDistance;
                }
        
                if (DefaultValueContributor is not null)
                {
                    return DefaultValueContributor;
                }
        
                if (DefaultValueRatio is not null)
                {
                    return DefaultValueRatio;
                }
        
                if (DefaultValueCanonical is not null)
                {
                    return DefaultValueCanonical;
                }
        
                if (DefaultValueExpression is not null)
                {
                    return DefaultValueExpression;
                }
        
                if (DefaultValueSignature is not null)
                {
                    return DefaultValueSignature;
                }
        
                if (DefaultValueUrl is not null)
                {
                    return DefaultValueUrl;
                }
        
                if (DefaultValueAnnotation is not null)
                {
                    return DefaultValueAnnotation;
                }
        
                if (DefaultValueUuid is not null)
                {
                    return DefaultValueUuid;
                }
        
                if (DefaultValueAddress is not null)
                {
                    return DefaultValueAddress;
                }
        
                if (DefaultValueString is not null)
                {
                    return DefaultValueString;
                }
        
                if (DefaultValueAge is not null)
                {
                    return DefaultValueAge;
                }
        
                if (DefaultValueOid is not null)
                {
                    return DefaultValueOid;
                }
        
                if (DefaultValueUsageContext is not null)
                {
                    return DefaultValueUsageContext;
                }
        
                if (DefaultValueParameterDefinition is not null)
                {
                    return DefaultValueParameterDefinition;
                }
        
                if (DefaultValueDateTime is not null)
                {
                    return DefaultValueDateTime;
                }
        
                if (DefaultValuePositiveInt is not null)
                {
                    return DefaultValuePositiveInt;
                }
        
                if (DefaultValueInteger is not null)
                {
                    return DefaultValueInteger;
                }
        
                if (DefaultValueTiming is not null)
                {
                    return DefaultValueTiming;
                }
        
                if (DefaultValueRelatedArtifact is not null)
                {
                    return DefaultValueRelatedArtifact;
                }
        
                if (DefaultValueIdentifier is not null)
                {
                    return DefaultValueIdentifier;
                }
        
                if (DefaultValueCodeableConcept is not null)
                {
                    return DefaultValueCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.DataRequirement))
                {
                    DefaultValueDataRequirement = (Base.DataRequirement)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Money))
                {
                    DefaultValueMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactPoint))
                {
                    DefaultValueContactPoint = (Base.ContactPoint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Meta))
                {
                    DefaultValueMeta = (Base.Meta)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    DefaultValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueCode = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.SampledData))
                {
                    DefaultValueSampledData = (Base.SampledData)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueMarkdown = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.HumanName))
                {
                    DefaultValueHumanName = (Base.HumanName)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDuration = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    DefaultValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueCount = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueId = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueBase64Binary = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ContactDetail))
                {
                    DefaultValueContactDetail = (Base.ContactDetail)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    DefaultValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    DefaultValuePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(Base.TriggerDefinition))
                {
                    DefaultValueTriggerDefinition = (Base.TriggerDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    DefaultValueReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDosage = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    DefaultValueRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueInstant = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    DefaultValueAttachment = (Base.Attachment)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    DefaultValueUnsignedInt = (uint)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDistance = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Contributor))
                {
                    DefaultValueContributor = (Base.Contributor)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    DefaultValueRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueCanonical = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceExpression))
                {
                    DefaultValueExpression = (Base.ResourceExpression)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Signature))
                {
                    DefaultValueSignature = (Base.Signature)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueUrl = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Annotation))
                {
                    DefaultValueAnnotation = (Base.Annotation)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueUuid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Address))
                {
                    DefaultValueAddress = (Base.Address)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueAge = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueOid = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.UsageContext))
                {
                    DefaultValueUsageContext = (Base.UsageContext)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ParameterDefinition))
                {
                    DefaultValueParameterDefinition = (Base.ParameterDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValuePositiveInt = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    DefaultValueInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefaultValueTiming = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.RelatedArtifact))
                {
                    DefaultValueRelatedArtifact = (Base.RelatedArtifact)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Identifier))
                {
                    DefaultValueIdentifier = (Base.Identifier)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DefaultValueCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ParameterDefinition? DefaultValueParameterDefinition { get; set; }
        public string? DefaultValueDateTime { get; set; }
        public string? DefaultValuePositiveInt { get; set; }
        public int? DefaultValueInteger { get; set; }
        public string? DefaultValueTiming { get; set; }
        public Base.RelatedArtifact? DefaultValueRelatedArtifact { get; set; }
        public Base.Identifier? DefaultValueIdentifier { get; set; }
        public Base.CodeableConcept? DefaultValueCodeableConcept { get; set; }
    }

    public class StructureMap_Group_Rule_Target_Parameter : BackboneElement
    {
        public object? Value    
        {
            get
            {
                if (ValueId is not null)
                {
                    return ValueId;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueId = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueId { get; set; }
        public string? ValueString { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueDecimal { get; set; }
        public int? ValueInteger { get; set; }
    }

    public class StructureMap_Group_Rule_Target : BackboneElement
    {
        public string? Context { get; set; }
        public string? Element { get; set; }
        public string[]? ListMode { get; set; }
        public string? Variable { get; set; }
        public StructureMap_Group_Rule_Target_Parameter[]? Parameter { get; set; }
        public string? Transform { get; set; }
        public string? ListRuleId { get; set; }
        public string? ContextType { get; set; }
    }

    public class StructureMap_Group_Rule_Dependent : BackboneElement
    {
        public required string Name { get; set; }
        public required string[] Variable { get; set; }
    }

    public class StructureMap_Group_Rule : BackboneElement
    {
        public required string Name { get; set; }
        public StructureMap_Group_Rule_Rule[]? Rule { get; set; }
        public required StructureMap_Group_Rule_Source[] Source { get; set; }
        public StructureMap_Group_Rule_Target[]? Target { get; set; }
        public StructureMap_Group_Rule_Dependent[]? Dependent { get; set; }
        public string? Documentation { get; set; }
    }

    public class StructureMap_Group_Input : BackboneElement
    {
        public required string Mode { get; set; }
        public required string Name { get; set; }
        public string? Type { get; set; }
        public string? Documentation { get; set; }
    }

    public class StructureMap_Group : BackboneElement
    {
        public required string Name { get; set; }
        public required StructureMap_Group_Rule[] Rule { get; set; }
        public required StructureMap_Group_Input[] Input { get; set; }
        public string? Extends { get; set; }
        public required string TypeMode { get; set; }
        public string? Documentation { get; set; }
    }

    public class StructureMap_Structure : BackboneElement
    {
        public required string Url { get; set; }
        public required string Mode { get; set; }
        public string? Alias { get; set; }
        public string? Documentation { get; set; }
    }
}