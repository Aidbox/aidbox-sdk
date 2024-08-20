using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class Questionnaire : DomainResource, IResource
{
    public string? Description { get; set; }
    public string[]? SubjectType { get; set; }
    public string? Date { get; set; }
    public string? Publisher { get; set; }
    public string? ApprovalDate { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string[]? DerivedFrom { get; set; }
    public string? Purpose { get; set; }
    public string? Name { get; set; }
    public Questionnaire_Item[]? Item { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public string? Title { get; set; }
    public required string Status { get; set; }
    public string? Url { get; set; }
    public Base.Coding[]? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? LastReviewDate { get; set; }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }
    public Base.Period? EffectivePeriod { get; set; }

    public class Questionnaire_Item_Item_EnableWhen : BackboneElement
    {
        public Base.Quantity? AnswerQuantity { get; set; }
        public string? AnswerDecimal { get; set; }
        public string? AnswerDate { get; set; }
        public Base.ResourceReference? AnswerReference { get; set; }
        public int? AnswerInteger { get; set; }
        public required string Question { get; set; }
        public string? AnswerDateTime { get; set; }
        public object? Answer    
        {
            get
            {
                if (AnswerQuantity is not null)
                {
                    return AnswerQuantity;
                }
        
                if (AnswerDecimal is not null)
                {
                    return AnswerDecimal;
                }
        
                if (AnswerDate is not null)
                {
                    return AnswerDate;
                }
        
                if (AnswerReference is not null)
                {
                    return AnswerReference;
                }
        
                if (AnswerInteger is not null)
                {
                    return AnswerInteger;
                }
        
                if (AnswerDateTime is not null)
                {
                    return AnswerDateTime;
                }
        
                if (AnswerString is not null)
                {
                    return AnswerString;
                }
        
                if (AnswerBoolean is not null)
                {
                    return AnswerBoolean;
                }
        
                if (AnswerCoding is not null)
                {
                    return AnswerCoding;
                }
        
                if (AnswerTime is not null)
                {
                    return AnswerTime;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    AnswerQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    AnswerReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    AnswerInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    AnswerBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    AnswerCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerTime = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? AnswerString { get; set; }
        public required string Operator { get; set; }
        public bool? AnswerBoolean { get; set; }
        public Base.Coding? AnswerCoding { get; set; }
        public string? AnswerTime { get; set; }
    }

    public class Questionnaire_Item_Item_AnswerOption : BackboneElement
    {
        public object? Value    
        {
            get
            {
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ValueReference = (Base.ResourceReference)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueDate { get; set; }
        public string? ValueTime { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public string? ValueString { get; set; }
        public int? ValueInteger { get; set; }
        public Base.ResourceReference? ValueReference { get; set; }
        public bool? InitialSelected { get; set; }
    }

    public class Questionnaire_Item_Item_Initial : BackboneElement
    {
        public Base.ResourceReference? ValueReference { get; set; }
        public string? ValueUri { get; set; }
        public string? ValueTime { get; set; }
        public string? ValueDecimal { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueUri is not null)
                {
                    return ValueUri;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
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
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
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
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
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
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
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
        public string? ValueDateTime { get; set; }
        public string? ValueDate { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public int? ValueInteger { get; set; }
        public Base.Attachment? ValueAttachment { get; set; }
    }

    public class Questionnaire_Item_Item : BackboneElement
    {
        public string? EnableBehavior { get; set; }
        public string? Definition { get; set; }
        public required string LinkId { get; set; }
        public bool? Repeats { get; set; }
        public string[]? Item { get; set; }
        public required string Type { get; set; }
        public Questionnaire_Item_Item_EnableWhen[]? EnableWhen { get; set; }
        public Questionnaire_Item_Item_AnswerOption[]? AnswerOption { get; set; }
        public string? Prefix { get; set; }
        public bool? ReadOnly { get; set; }
        public string? AnswerValueSet { get; set; }
        public Base.Coding[]? Code { get; set; }
        public Questionnaire_Item_Item_Initial[]? Initial { get; set; }
        public int? MaxLength { get; set; }
        public bool? Required { get; set; }
        public string? Text { get; set; }
    }

    public class Questionnaire_Item_EnableWhen : BackboneElement
    {
        public Base.Quantity? AnswerQuantity { get; set; }
        public string? AnswerDecimal { get; set; }
        public string? AnswerDate { get; set; }
        public Base.ResourceReference? AnswerReference { get; set; }
        public int? AnswerInteger { get; set; }
        public required string Question { get; set; }
        public string? AnswerDateTime { get; set; }
        public object? Answer    
        {
            get
            {
                if (AnswerQuantity is not null)
                {
                    return AnswerQuantity;
                }
        
                if (AnswerDecimal is not null)
                {
                    return AnswerDecimal;
                }
        
                if (AnswerDate is not null)
                {
                    return AnswerDate;
                }
        
                if (AnswerReference is not null)
                {
                    return AnswerReference;
                }
        
                if (AnswerInteger is not null)
                {
                    return AnswerInteger;
                }
        
                if (AnswerDateTime is not null)
                {
                    return AnswerDateTime;
                }
        
                if (AnswerString is not null)
                {
                    return AnswerString;
                }
        
                if (AnswerBoolean is not null)
                {
                    return AnswerBoolean;
                }
        
                if (AnswerCoding is not null)
                {
                    return AnswerCoding;
                }
        
                if (AnswerTime is not null)
                {
                    return AnswerTime;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    AnswerQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    AnswerReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    AnswerInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    AnswerBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    AnswerCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AnswerTime = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? AnswerString { get; set; }
        public required string Operator { get; set; }
        public bool? AnswerBoolean { get; set; }
        public Base.Coding? AnswerCoding { get; set; }
        public string? AnswerTime { get; set; }
    }

    public class Questionnaire_Item_AnswerOption : BackboneElement
    {
        public object? Value    
        {
            get
            {
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ValueReference = (Base.ResourceReference)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueDate { get; set; }
        public string? ValueTime { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public string? ValueString { get; set; }
        public int? ValueInteger { get; set; }
        public Base.ResourceReference? ValueReference { get; set; }
        public bool? InitialSelected { get; set; }
    }

    public class Questionnaire_Item_Initial : BackboneElement
    {
        public Base.ResourceReference? ValueReference { get; set; }
        public string? ValueUri { get; set; }
        public string? ValueTime { get; set; }
        public string? ValueDecimal { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueUri is not null)
                {
                    return ValueUri;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
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
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
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
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
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
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
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
        public string? ValueDateTime { get; set; }
        public string? ValueDate { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public int? ValueInteger { get; set; }
        public Base.Attachment? ValueAttachment { get; set; }
    }

    public class Questionnaire_Item : BackboneElement
    {
        public string? EnableBehavior { get; set; }
        public string? Definition { get; set; }
        public required string LinkId { get; set; }
        public bool? Repeats { get; set; }
        public Questionnaire_Item_Item[]? Item { get; set; }
        public required string Type { get; set; }
        public Questionnaire_Item_EnableWhen[]? EnableWhen { get; set; }
        public Questionnaire_Item_AnswerOption[]? AnswerOption { get; set; }
        public string? Prefix { get; set; }
        public bool? ReadOnly { get; set; }
        public string? AnswerValueSet { get; set; }
        public Base.Coding[]? Code { get; set; }
        public Questionnaire_Item_Initial[]? Initial { get; set; }
        public int? MaxLength { get; set; }
        public bool? Required { get; set; }
        public string? Text { get; set; }
    }
}